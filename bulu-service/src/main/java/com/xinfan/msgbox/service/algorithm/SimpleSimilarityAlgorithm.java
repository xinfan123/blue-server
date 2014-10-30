package com.xinfan.msgbox.service.algorithm;

import ruc.irm.similarity.sentence.morphology.MorphoSimilarity;

import com.xinfan.msgbox.vo.CachedMessage;

public class SimpleSimilarityAlgorithm implements SimilarityAlgorithm {

	@Override
	public boolean matched(CachedMessage interests, CachedMessage message) {

		MorphoSimilarity similarity = MorphoSimilarity.getInstance();

		double score = similarity.getSimilarity(interests.getOriginalMsg(), message.getOriginalMsg());

		if (score > 0.7) {
			return true;
		}

		return false;
		// return interests.getOriginalMsg().equals(message.getOriginalMsg());
	}

}
