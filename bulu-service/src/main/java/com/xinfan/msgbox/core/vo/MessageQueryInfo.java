package com.xinfan.msgbox.core.vo;

import java.util.ArrayList;
import java.util.List;

public class MessageQueryInfo {
	private CachedMessage current;
	private List<Long> candidates = new ArrayList<Long>();
	private List<Long> excludes = new ArrayList<Long>();
	public CachedMessage getCurrent() {
		return current;
	}
	public void setCurrent(CachedMessage current) {
		this.current = current;
	}
	public List<Long> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Long> candidates) {
		this.candidates = candidates;
	}
	public List<Long> getExcludes() {
		return excludes;
	}
	public void setExcludes(List<Long> excludes) {
		this.excludes = excludes;
	}

}
