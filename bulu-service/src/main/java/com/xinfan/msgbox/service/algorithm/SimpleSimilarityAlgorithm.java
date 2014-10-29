package com.xinfan.msgbox.service.algorithm;

import com.xinfan.msgbox.vo.CachedMessage;

public class SimpleSimilarityAlgorithm implements SimilarityAlgorithm{

	@Override
	public boolean matched(CachedMessage interests, CachedMessage message) {
		return interests.getOriginalMsg().equals(message.getOriginalMsg());
	}

}
