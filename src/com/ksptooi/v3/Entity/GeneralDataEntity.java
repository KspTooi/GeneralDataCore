package com.ksptooi.v3.Entity;

import java.util.ArrayList;

import uk.iksp.v7.main.DataCore;

public class GeneralDataEntity {

	
	int index=0;
	
	ArrayList<String> Content = null;
	
	//构造方法
	public GeneralDataEntity(ArrayList<String> al){
		
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
	
	
	//数据操作
	
	
	//添加新的行内容
	public void addline(String value) {	
		this.addLast(value);
	}
	
	
	//添加新的key
	public void put(String key,String value) {			
		this.addLast(key+"="+value);		
	}
	
	
	//修改value
	public void set(String key,String value) {
			
		while(this.next()){
			
			if(this.get().contains(key+"=")){
				
				
				this.set(key+"="+value);
				
			}
				
		}
		
		this.reset();	
		
	}
	
	
	//删除
	public void remove(String key) {
		
		while(this.next()){
			
			if(this.get().contains(key+"=")){
				
				this.remove();
				
			}
				
		}
		
		this.reset();
	}
	
	//查询
	public String get(String key) {
		
		while(this.next()){
			
			if(this.get().contains(key+"=")){
				
				String str = this.get().replace(key+"=", "");
				
				this.reset();
				
				return str;
				
			}
				
		}
		
		DataCore.logManager.logWarning("文件系统错误! 未找到Key - " + key);
		
		return null;
		
	}
	
	//返回实体中有多少行与Match相同的字符串
	public int getRepeat(String Match){
		
		int count=0;
				
		while(this.next()){
					
			if(this.get().equals(Match)){
				count++;
			}	
			
		}
	
		return count;

	}
	
	
	
	//查询KeyList
	public KeyList getKeyList(String key) {
		
		ArrayList<String> al=new ArrayList<String>();
		
		
		while(this.next()){
			
			if(this.get().contains(key+"=")){
				
				String str = this.get().replace(key+"=", "");
						
				al.add(str);	
			}
				
		}
		
		this.reset();
		
		if(al.size()==0){
			DataCore.logManager.logWarning("文件系统错误! 未找到Key - " + key);
			return null;
		}
		
		
		//生成KeyList
		
		KeyList kl=new KeyList(al,key);
		return kl;	
	}
	
	
	//更新KeyList
	public void setKeyList(KeyList keyList){
		
		
		String key=keyList.getKey();
		
		int index = 0;
		
		while((this.next() && (index<keyList.getSize()))){
			
			if(this.get().contains(key+"=")){
				
				this.set(key+"="+keyList.index(index));
				index++;
				
			}
				
		}
		
		this.reset();	
		
	}
	
	
}
