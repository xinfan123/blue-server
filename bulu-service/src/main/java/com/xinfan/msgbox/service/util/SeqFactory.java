package com.xinfan.msgbox.service.util;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.xinfan.msgbox.http.context.AppContextHolder;

public class SeqFactory {

	private SqlSessionTemplate template;

	public static final String SEQ_USER = "seq_user";

	public static final String SEQ_MESSAGE = "seq_message";

	public static final String SEQ_RECEVIE = "seq_recevie";

	private static SeqFactory instance;

	public static synchronized SeqFactory getInstance() {
		if (instance == null) {
			instance = new SeqFactory();
			instance.template = AppContextHolder.getBean(SqlSessionTemplate.class);
		}

		return instance;
	}

	public long getSeq(String name) {
		Map map = new HashMap();
		map.put("seq_name", name);
		template.selectOne("SeqMapper.getSeq", map);

		long value = (Integer) map.get("seq_value");
		return value;
	}

	public long getSeqUser() {
		return getSeq(SEQ_USER);
	}

	public long getSeqMessage() {
		return getSeq(SEQ_MESSAGE);
	}

	public long getSeqReceive() {
		return getSeq(SEQ_RECEVIE);
	}

}
