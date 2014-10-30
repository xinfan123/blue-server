package com.xinfan.msgbox.service.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ruc.irm.similarity.sentence.morphology.MorphoSimilarity;

import com.xinfan.msgbox.vo.CachedMessage;

public class SimpleSimilarityAlgorithm implements SimilarityAlgorithm {

	private static Logger logger = LoggerFactory.getLogger(SimilarityAlgorithm.class);

	@Override
	public boolean matched(CachedMessage interests, CachedMessage message) {

		MorphoSimilarity similarity = MorphoSimilarity.getInstance();

		double score = similarity.getSimilarity(interests.getOriginalMsg(), message.getOriginalMsg());

		logger.debug("similarity score:  " + score + "{+" + interests.getOriginalMsg() + "," + message.getOriginalMsg() + "+}");

		if (score > 0.7) {
			return true;
		}

		return false;
		// return interests.getOriginalMsg().equals(message.getOriginalMsg());
	}

}
