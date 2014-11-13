package com.xinfan.msgbox.service.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfan.msgbox.vo.CachedMessage;

public class SimHashAlgorithm implements SimilarityAlgorithm {
	private static Logger logger = LoggerFactory.getLogger(SimilarityAlgorithm.class);

	@Override
	public boolean matched(CachedMessage interests, CachedMessage message) {

		double score = calcSimilarity(interests, message);

		logger.debug("similarity score:  " + score + "{" + interests.getOriginalMsg() + "," + message.getOriginalMsg() + "}");

		if (score > 0.7) {
			return true;
		}

		return false;
	}

	@Override
	public double calcSimilarity(CachedMessage interests, CachedMessage message) {

		return SimHash.getSimilarity(interests.getOriginalMsg(), message.getOriginalMsg());
	}

}
