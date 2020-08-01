package com.ksptooi.generaldatacore.common;

public class Type {
	
	

	public static Integer toInt(String s) {
		
		Integer i = null;
		
		try {
			
			i = Integer.valueOf(s);
			return i;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static Double toDouble(String s) {
		
		Double d = null;
		
		try {
			
			d = Double.valueOf(s);
			return d;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static Float toFloat(String s) {
		
		Float f = null;
		
		try {
			
			f = Float.valueOf(s);
			return f;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static Boolean toBoolean(String s) {
		
		Boolean b = null;
		
		try {
			
			b = Boolean.valueOf(s);
			return b;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
	

}
