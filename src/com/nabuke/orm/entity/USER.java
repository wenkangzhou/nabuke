package com.nabuke.orm.entity;

import java.io.Serializable;

public class USER implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8408934328187755104L;
	/**
	 * id
     */
	private Integer id;
	/**
	 * 用户名
     */
	private String username;
	/**
	 * 密码
     */
	private String password;
	/**
	 * 角色id
     */
	private Integer roleid;
	/**
	 * 状态（0正常 1删除）
     */
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
