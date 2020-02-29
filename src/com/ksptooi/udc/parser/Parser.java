package com.ksptooi.udc.parser;


/**
 * 兼容旧版数据格式的解析器
 */
public class Parser {
	
	
	/**
	 * 从字符串中解析出key
	 * @param str 要解析的字符串
	 * @return key
	 */
	public static String toKey(String str) {
		
		
		int keyStart = 0;
		int keyEnd = 0;
		int markCount = 0;
		
		//查找key标识符位置
		for(int i=0;i<str.length();i++) {
			
			
			if(str.charAt(i) == '"'){
				
				if(markCount<1) {
//					System.out.println("开始:"+i);
					keyStart = i;
					markCount ++;
					continue;
				}
				
				if(markCount==1) {
//					System.out.println("结束:"+i);
					keyEnd = i;
					markCount ++;
				}	
			}
				
		}
		
		return str.substring(keyStart+1, keyEnd);
		
	}
	
	/**
	 * 从字符串中解析出value
	 * @param str 要解析的字符串
	 * @return value
	 */
	public static String toValue(String str) {
		
		int valueMarkIndex = str.indexOf("=");
		
		return str.substring(valueMarkIndex+1);
		
	}
	
	
	
}
