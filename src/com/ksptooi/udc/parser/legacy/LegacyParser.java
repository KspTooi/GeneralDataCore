package com.ksptooi.udc.parser.legacy;


/**
 * 兼容旧版数据格式的解析器
 */
public class LegacyParser {

	/**
	 * ![Legacy]
	 * 从字符串中解析出key
	 * @param str 要解析的字符串
	 * @return key
	 */
	public static String toKey(String str) {
		
		int valueMarkIndex = str.indexOf("=");
		
		return str.substring(0, valueMarkIndex);
		
	}
	
	/**
	 * ![Legacy]
	 * 从字符串中解析出value
	 * @param str 要解析的字符串
	 * @return value
	 */
	public static String toValue(String str) {
		
		int valueMarkIndex = str.indexOf("=");
		
		return str.substring(valueMarkIndex+1);
		
	}
	
	
}
