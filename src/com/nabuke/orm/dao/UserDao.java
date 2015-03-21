package com.nabuke.orm.dao;

import com.nabuke.orm.entity.USER;


public interface UserDao {
	 USER selectUserById(Integer id);
}
