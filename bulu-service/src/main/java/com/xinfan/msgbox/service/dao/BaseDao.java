/**
 * 
 */
package com.xinfan.msgbox.service.dao;

import java.util.List;

import com.xinfan.msgbox.service.dao.dal.SqlSessionDaoSupport;

public class BaseDao<T,V> extends SqlSessionDaoSupport {

	public int deleteByPrimaryKey(Object obj) {
		return (Integer)this.getSqlSession().delete(wrapCommand("deleteByPrimaryKey"), obj);
	}

	public int insertSelective(T record) {
		return this.getSqlSession().insert(wrapCommand("insertSelective"), record);
	}

	public List<T> selectByExample(V example) {
		return this.getSqlSession().selectList(wrapCommand("selectByExample"), example);
	}

	public T selectByPrimaryKey(Object id) {
		return this.getSqlSession().selectOne(wrapCommand("selectByPrimaryKey"), id);
	}

	public int updateByPrimaryKeySelective(T record) {
		return this.getSqlSession().update(wrapCommand("updateByPrimaryKeySelective"), record);
	}

	public int updateByPrimaryKey(T record) {
		return this.getSqlSession().update(wrapCommand("updateByPrimaryKey"), record);
	}
	
}
