package com.ishiyamasayuri.Entity;

import java.util.ArrayList;

public class GDCEntity {

	
	int index=0;
	
	ArrayList<String> Content = null;
	
	//构造方法
	public GDCEntity(ArrayList<String> al){
		
		this.Content=al;
		
	}
	
	
	//下一个光标
	public boolean next(){

		
		if(index < Content.size()){
			index++;
			return true;
		}
		
		return false;
		
	}
	
	
	//获取当前
	public String get(){
			
		return Content.get(index-1);
		
	}
	
	public String getFirst(){
		index++;
		return Content.get(0);
	}
	
	
	//添加到末尾
	public void addLast(String str){
		Content.add(str);
	}
	
	public void reset(){
		index = 0;
	}
	
	
}
