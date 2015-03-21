package com.nabuke.orm.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.nabuke.orm.dao.UserDao;
import com.nabuke.orm.entity.USER;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
@Repository("userDAO")
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao{
	public UserDaoImpl(){
		super();
	}
	/*
	 * Hack For [Property 'sqlMapClient' is required] 
	 */
	@Resource(name = "sqlMapClient")
	private SqlMapClient sqlMapClient;
	 
	@PostConstruct        
	public void initSqlMapClient(){
	  super.setSqlMapClient(sqlMapClient);    
	}
	@Override
	public USER selectUserById(Integer id) {
		USER user = new USER();
		user.setId(id);
		USER result = (USER) getSqlMapClientTemplate().queryForObject("t_user.selectUserById", user);
        return result;
	}

}
