package com.ksptooi.v3.Entity;

import java.util.ArrayList;

public class GeneralDataListEntity{

	
	
	ArrayList<String> al=new ArrayList<String>();
	
	
	
	public GeneralDataListEntity(ArrayList<String> al) {
		
		this.al=al;
		
	}
	
	
	public GeneralDataListEntity(String str) {
		
		String[] split = str.split(",");
		
		
		for(String s:split) {
			
			al.add(s);
			
		}	
		
	}
	
	
	public ArrayList<String> toArrayList(){
		return al;
	}
	
	
	public String toString() {
		
		String str = "";
		
		
		boolean flag=false;
		
		
		
		for(String s:al) {
			
			
			if(flag == false) {
				
				str = str + s;
				
				flag = true;
				
				continue;
			}
			
			str = str+","+ s;		
			
		}
		
		
		
		return str;
		
	}
	
	
	
	
}
