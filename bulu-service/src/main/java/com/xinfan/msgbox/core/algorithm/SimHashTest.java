package com.xinfan.msgbox.core.algorithm;

public class SimHashTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		long start  = System.currentTimeMillis();
		
		for(int i=0;i<1;i++){
			String word1 = "本的长期寻长有想法的伙伴一起共事本的长期寻长有想法的伙伴一起共事";
			String word2 = "求有想法的伙伴一起创业本的长期寻长有想法的伙伴一起共事s/ss" +
					"";
			double f = SimHash.getSimilarity(word1, word2);
			System.out.println(f);
		}
		
		
		long end = System.currentTimeMillis();
		
		
		System.out.println((end-start));
		

	}

}
