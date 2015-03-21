package com.nabuke.services.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nabuke.orm.dao.UserDao;
import com.nabuke.orm.entity.USER;
import com.nabuke.services.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDAO")
	private UserDao userDAO;
	@Override
	public USER findUserById(Integer id) {
		return this.userDAO.selectUserById(id);
	}

}
