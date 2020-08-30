package com.ksptooi.generaldatacore.parser;

import java.util.ArrayList;

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
	 * 替换当前的value为新的value
	 * item: key=xxx
	 * value: 要替换的value
	 */
	public static String setValue(String item,String value) {
		
		String key = key(item);
		
		return key + "=" + value;
	}

	/**
	 * 格式化key和value
	 */
	public static String format(String key,String value){
		return key+"="+value;
	}

	/**
	 * 将list转换为value
	 */
	public static String listToString(ArrayList<String> list){

		StringBuffer sb = new StringBuffer();

		for(int i=0;i<list.size();i++){

			sb.append(list.get(i));

			if((i+1)<list.size()){
				sb.append(",");
			}

		}

		return sb.toString();
	}

	/**
	 * 将value转换为list
	 */
	public static ArrayList<String> stringToList(String value){

		ArrayList<String> list = new ArrayList<String>();

		String[] split = value.split(",");

		//转换后的字符串为0
		if(split.length<1){
			return null;
		}

		for(String s:split){
			list.add(s);
		}

		return list;
	}

}
