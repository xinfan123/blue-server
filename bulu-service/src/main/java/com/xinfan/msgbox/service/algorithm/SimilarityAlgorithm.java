package com.xinfan.msgbox.service.algorithm;

import com.xinfan.msgbox.vo.CachedMessage;

public interface SimilarityAlgorithm {
	boolean matched(CachedMessage interests,CachedMessage message);
}
