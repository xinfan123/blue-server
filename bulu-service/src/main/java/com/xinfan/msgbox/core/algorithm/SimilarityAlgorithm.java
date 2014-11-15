package com.xinfan.msgbox.core.algorithm;

import com.xinfan.msgbox.vo.CachedMessage;

public interface SimilarityAlgorithm {
	boolean matched(CachedMessage interests,CachedMessage message);
	double calcSimilarity(CachedMessage interests,CachedMessage message);
}
