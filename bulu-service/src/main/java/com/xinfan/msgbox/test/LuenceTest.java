/*package com.xinfan.msgbox.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;

public class LuenceTest {

	private static String indexPath = "E:\\Lucene\\index"; // 索引保存目录

	public static void createIndex() { // 建立索引
		IndexWriter writer;
		try {
			writer = new IndexWriter(indexPath, new StandardAnalyzer());

			Field fieldB1 = new Field("contents", "今晚的辩题很道地：在我们这些人当中？",
					Field.Store.YES, Field.Index.TOKENIZED);
			Field fieldB2 = new Field("contents", "我们为电影《今朝》是一部不错的影片。",
					Field.Store.YES, Field.Index.TOKENIZED);
			Field fieldB3 = new Field("contents", "我们到底是啥意思呢？",
					Field.Store.YES, Field.Index.TOKENIZED);
			Document doc1 = new Document();
			Document doc2 = new Document();
			Document doc3 = new Document();
			doc1.add(fieldB1);
			doc2.add(fieldB2);
			doc3.add(fieldB3);

			writer.addDocument(doc1);
			writer.addDocument(doc2);
			writer.addDocument(doc3);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {

		Query query;
		IndexSearcher searcher;
		IndexReader reader = new IndexReader();
		try {
			// 生成索引
			createIndex();
			searcher = new IndexSearcher();
			// 要查找的字符串数组
			String[] stringQuery = { "我们", "今晚" };
			// 待查找字符串对应的字段
			String[] fields = { "contents", "contents" };
			// Occur.MUST表示对应字段必须有查询值， Occur.MUST_NOT 表示对应字段必须没有查询值
			Occur[] occ = { Occur.MUST, Occur.MUST };

			query = MultiFieldQueryParser.parse(stringQuery, fields, occ,
					new StandardAnalyzer());
			TopDocs hits = searcher.search(query,5);
			for (int i = 0; i < hits.totalHits; i++)
				System.out.println("Document内容为 ： " + hits.scoreDocs[i]);
			System.out.println("共检索出符合条件的Document " + hits.totalHits + " 个。");
		} catch (Exception e) {
		}
	}

}
*/