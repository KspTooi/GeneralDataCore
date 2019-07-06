package com.ksptooi.gdc.Entity;

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
	
	//删除当前
	public void remove() {
		
		Content.remove(index -1);
		index = index -1;
		
	}
	
	
	//获取当前(索引)
	public String get(){
			
		return Content.get(index-1);
		
	}
	
	//设置当前(索引)
	public void set(String str){
		Content.set(index-1, str);
	}
	
	
	
	//取第一行内容
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
	
	//判断数据是否为空
	public boolean isNull(){
		
		if(Content.size()<1){
			return true;
		}
		
		return false;
		
	}
	
}
