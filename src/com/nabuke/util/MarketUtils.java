package com.nabuke.util;

import javax.servlet.http.HttpServletRequest;


public class MarketUtils {

	/*
	 * 所有接口条用处理失败时返回错误信息，result=0|1 result：0-处理失败；1-处理成功； innerText：错误详细信息
	 */
	public static String getErrorJson(String desc) {
		StringBuffer buf = new StringBuffer();
		buf.append("{result:0,msg:\"");
		buf.append(desc);
		buf.append("\"}");
		return buf.toString();
	}
	
	public static String getErrorJson(String desc,String jsoncallback) {
		if(jsoncallback == null || jsoncallback.length() < 1){
			return getErrorJson(desc);
		}
		StringBuffer buf = new StringBuffer();
		buf.append(jsoncallback);
		buf.append("({result:0,msg:\"");
		buf.append(desc);
		buf.append("\"})");
		return buf.toString();
	}
	
	/*
	 * 所有接口条用处理失败时返回错误信息，result=0|1 result：0-处理失败；1-处理成功； innerText：错误详细信息
	 */
	public static String getErrorJson(String desc,int flag) {
		StringBuffer buf = new StringBuffer();
		buf.append("{result:0,msg:\"");
		buf.append(desc);
		buf.append("\",flag:");
		buf.append(flag);
		buf.append("}");
		return buf.toString();
	}
	/*
	 * 所有接口条用处理成功时返回错误信息，result=0|1 result：0-处理失败；1-处理成功； innerText：错误详细信息
	 */
	public static String getResJson(String desc) {
		StringBuffer buf = new StringBuffer();
		buf.append("{\"result\":1,\"data\":");
		buf.append(desc);
		buf.append("}");
		return buf.toString();
	}
	
	public static String getResJson(String desc,String jsoncallback) {
		if(jsoncallback == null || jsoncallback.length() < 1){
			return getResJson(desc);
		}
		StringBuffer buf = new StringBuffer();
		buf.append(jsoncallback);
		buf.append("({\"result\":1,\"data\":");
		buf.append(desc);
		buf.append("})");
		return buf.toString();
	}
	/**
	 * 获取IP地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}

