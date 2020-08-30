package com.ksptooi.generaldatacore.parser;

import java.util.ArrayList;

public class ListParser {

	

	/**
	 * 将list转为字符串
	 */
	public static String string(ArrayList<String> inputList) {
		
		StringBuffer sb = new StringBuffer();
		
		
		ArrayList<String> list = inputList;
		
		
		for(int i=0;i<list.size();i++) {
			
			if(i<1) {
				sb.append(list.get(i));
				continue;
			}
			
			
			
			sb.append(System.lineSeparator() +list.get(i));
			
		}
		
		
		return sb.toString();		
	}
	
	
	/**
	 * 找到key的所在行
	 */
	public static int indexOf(String inputKey,ArrayList<String> list) {
		
		
		try {
			
			
			String key = null;
			
			int flag = 0;
			
			for(String item:list) {
				
				flag++;
				key = KVParser.key(item);
				
				if(item == null ||key == null|| item.equals("")) {
					continue;
				}
				
				if(key.equals(inputKey)) {
					return flag;
				}
				
			}
			

			
		}catch(NullPointerException npe) {
			npe.printStackTrace();
			return -1;
		}
			
		return -1;
		
	}
	
	
}
