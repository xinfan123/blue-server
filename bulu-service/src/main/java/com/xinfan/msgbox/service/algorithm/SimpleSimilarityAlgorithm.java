package com.xinfan.msgbox.service.algorithm;

import com.xinfan.msgbox.vo.CachedMessage;

public class SimpleSimilarityAlgorithm implements SimilarityAlgorithm{

	@Override
	public boolean matched(CachedMessage interests, CachedMessage message) {
		// TODO Auto-generated method stub
		return interests.getOriginalMsg().equals(message.getOriginalMsg());
	}

}
