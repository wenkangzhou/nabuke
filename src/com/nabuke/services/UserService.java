package com.nabuke.services;

import com.nabuke.orm.entity.USER;



/**
 * 用户信息
 */
public interface UserService {
	/**
	 * 根据ID查询分类信息
	 * 
	 * @param id 主键ID
	 * @return
	 */
	USER findUserById(Integer id);
}
