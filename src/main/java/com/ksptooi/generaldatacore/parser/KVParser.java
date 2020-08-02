package com.ksptooi.generaldatacore.parser;

public class KVParser {
	
	
	
	
	/**
	 * 从字符串中解析出key
	 * @return
	 */
	public static String key(String s) {
		
		
		int flag = s.indexOf("=", 0);
		
		
		if(flag == -1) {		
			return null;
		}
		
		return s.substring(0, flag);
	}
	
	/**
	 * 从字符串中解析出value
	 * @param s
	 * @return
	 */
	public static String value(String s) {
		
		int flag = s.indexOf("=",0);
		
		String result = null;
		
		if(flag == -1) {
			return null;
		}
		
		result = s.substring(flag+1,s.length());
		
		if(result.equalsIgnoreCase("") || result.equalsIgnoreCase(" ")) {
			return null;
		}
				
				
		return s.substring(flag+1,s.length());
	}
	
	/**
	 * 设置指定item的value值
	 */
	public static String setValue(String item,String value) {
		
		String key = key(item);
		
		return key + "=" + value;
		
	}
	
	
	
	
	
	
	
	
	
	

}
