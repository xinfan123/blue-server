package com.xinfan.msgbox.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class LuenceTest2 {

	protected String[] ids = { "1", "2" };

	protected String[] content = { "Amsterdam has lost of add  cancals",
			"i love  add this girl" };

	protected String[] city = { "Amsterdam", "Venice" };

	private Directory dir;

	/**
	 * 初始添加文档
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		String pathFile = "D://lucene/index";
		String dataFile = "d://lucene/data/data.txt";

		dir = FSDirectory.open(new File(pathFile));
		IndexWriter writer = getWriter();

		FileInputStream fis = new FileInputStream(new File(dataFile));
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis,
				"GBK"));

		String line = "";
		while ((line = reader.readLine()) != null) {
			Document doc = new Document();
			doc.add(new StringField("id", String.valueOf(line.hashCode()),
					Store.YES));
			doc.add(new TextField("content", line, Store.YES));
			writer.addDocument(doc);
		}

		reader.close();
		writer.close();

		System.out.println("init ok");

	}

	/**
	 * 获得IndexWriter对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public IndexWriter getWriter() throws Exception {
		Analyzer analyzer = new IKAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LATEST,
				analyzer);
		return new IndexWriter(dir, iwc);
	}

	public void search(String[] keyword) throws Exception {
		
		Directory dir = getDir();
		
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		
		Sort sort = new Sort(new SortField("id", SortField.Type.INT,
				true));

		Term term = new Term("content", keyword[0]);
		TermQuery query = new TermQuery(term);
		TopDocs topdocs = searcher.search(query, 5);
		ScoreDoc[] scoreDocs = topdocs.scoreDocs;
		System.out.println("查询结果总数---" + topdocs.totalHits + "最大的评分--"
				+ topdocs.getMaxScore());

		/*
		 * for (int i = 0; i < scoreDocs.length; i++) { int doc =
		 * scoreDocs[i].doc; Document document = searcher.doc(doc);
		 * System.out.println("content====" + document.get("content"));
		 * System.out.println("id--" + scoreDocs[i].doc + "---scors--" +
		 * scoreDocs[i].score + "---index--" + scoreDocs[i].shardIndex); }
		 */
		
		IKAnalyzer analyzer = new IKAnalyzer();
		Query mulQuery = MultiFieldQueryParser.parse(keyword, new String[] {
				"content", "content" }, new Occur[] { Occur.SHOULD,
				Occur.SHOULD }, analyzer);
		
		SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<red>", "</red>");
		Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(mulQuery));

		TopDocs hits = searcher.search(mulQuery, 2, sort);
		for (int i = 0; i < hits.scoreDocs.length; i++){
			ScoreDoc doc = hits.scoreDocs[i];
			System.out.println("Document内容为 ： " + doc);
	        TokenStream tokenStream2 = analyzer.tokenStream("content", searcher.doc(doc.doc).get("content"));
	        String content = highlighter.getBestFragment(tokenStream2,  searcher.doc(doc.doc).get("content"));	
	        System.out.println(content);
		}

		System.out.println("共检索出符合条件的Document " + hits.totalHits + " 个。");

		reader.close();

	}

	private Directory getDir() throws IOException {
		String filePath = "D://lucene/index";
		Directory dir = FSDirectory.open(new File(filePath));
		return dir;
	}
	
    public void delete()  
    {  
        IndexWriter writer=null;  
        try {  
            writer=new IndexWriter(getDir(), new IndexWriterConfig(Version.LATEST,  
                    new StandardAnalyzer(Version.LATEST)));  
            //参数十一个选项，可以是一个query，也可以是一个term  term就是一个精确查找的值  
            //此时删除的文档并未完全删除，而是存储在回收站中，可以恢复的  
            writer.deleteDocuments(new Term("id","1"));  
            
        } catch (CorruptIndexException e) {  
            e.printStackTrace();  
        } catch (LockObtainFailedException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        finally{  
            if (writer!=null) {  
                try {  
                    writer.close();  
                } catch (CorruptIndexException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
        }  
    } 
    
    //更新索引  
    public void update()  
    {  
        /*lucene本身不支持更新 
         *  
         * 通过删除索引然后再建立索引来更新 
         */  
          IndexWriter writer=null;  
           Document doc=null;  
           try {  
            writer =new IndexWriter(this.getDir(),new IndexWriterConfig(Version.LUCENE_36,   
                       new StandardAnalyzer(Version.LUCENE_36)));  
            writer.deleteAll();  
            for(int i=0;i<ids.length;i++)  
            {  
                doc=new Document();  
                doc.add(new StringField("id","fffffffff",Field.Store.YES));  
                doc.add(new StringField("contents","fffffff",Field.Store.YES));  
                writer.updateDocument(new Term("id","1"), doc);   
            }  
        } catch (CorruptIndexException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (LockObtainFailedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
           finally{  
               if(writer!=null)  
               {  
                  try {  
                    writer.close();  
                } catch (CorruptIndexException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }     
               }  
           }      
    }  

	/**
	 * 查询
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		String[] keyword = { "如何创建索", "陈" };

		LuenceTest2 test = new LuenceTest2();

		//test.init();

		test.search(keyword);
	}
}
