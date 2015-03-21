package com.nabuke.controller;
import com.nabuke.orm.entity.USER;
import com.nabuke.services.UserService;
import com.nabuke.util.MarketUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller  
@RequestMapping("/test")
public class Test {
	@Resource(name = "userService")
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/mysqlconnect/{id}",method = RequestMethod.POST)
	public String mysqlconnect(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) {

		response.setContentType("text/xml;charset=UTF-8");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.addHeader("Access-Control-Allow-Origin", "*");  
	    response.addHeader("Access-Control-Allow-Headers", "x-requested-with"); 
		
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		USER user = this.userService.findUserById(id);
		String data =user.getId()+"#"+user.getUsername()+"#"+user.getPassword()+"#"+user.getRoleid()+"#"+user.getStatus();
		System.out.println("username:"+username+"###进入###content:"+content);
		System.out.println("data:"+data);
		StringBuilder sb = new StringBuilder();
		sb.append("{\"username\":\"");
		sb.append(username);
		sb.append("\",\"content\":\"");
		sb.append(content);
		sb.append("\",\"datafrommysql\":\"");
		sb.append(data);
		sb.append("\"}");
		System.out.println("sb:"+sb.toString());
		return MarketUtils.getResJson(sb.toString());
	}
}
