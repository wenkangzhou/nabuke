package com.nabuke.controller;
import java.io.BufferedReader;
import java.io.IOException;

import com.nabuke.orm.entity.USER;
import com.nabuke.services.UserService;
import com.nabuke.util.MarketUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller  
@RequestMapping("/test")
public class Test {
	@Resource(name = "userService")
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/mysqlconnect/{id}",method = {RequestMethod.POST,RequestMethod.OPTIONS})//, produces="application/json;charset=UTF-8"
	public String mysqlconnect(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) {//,@RequestParam(value = "username",required=false) String username
		//response.setContentType("application/json");   
	    response.setHeader("Access-Control-Allow-Origin", "*");  
	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Content-Type"); 
	    String method = request.getMethod().toString();
		System.out.println("method:"+method);
		if(method.equals("OPTIONS")){
			return null;
		}
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		if(username == null || content == null){
			JSONObject jsonObj = null;
			try {
				 StringBuilder sb = new StringBuilder();  
		         BufferedReader reader = request.getReader();
		         char[]buff = new char[1024];  
		         int len;  
		         while((len = reader.read(buff)) != -1) {  
		              sb.append(buff,0, len);  
		         }  
		         System.out.println("jsonstr:"+sb.toString());  
		         jsonObj = JSONObject.fromObject(sb.toString());
		         System.out.println("content:"+jsonObj.get("content"));  
			} catch (IOException e) {
				e.printStackTrace();
			}
			username = jsonObj.get("username").toString();
			content = jsonObj.get("content").toString();
		}
		
		USER user = this.userService.findUserById(id);
		String data =user.getId()+"#"+user.getUsername()+"#"+user.getPassword()+"#"+user.getRoleid()+"#"+user.getStatus();
		System.out.println("username:"+username+"###内容###content:"+content);
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
