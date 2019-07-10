package com.ksptooi.gdc.v6.FileProcess;

import com.ksptooi.gdc.Entity.GDCEntity;
import com.ksptooi.gdc.Main.DataCore;

public class dataProcess {

	
	//添加新的行内容
	public GDCEntity addline(GDCEntity data,String value) {
				
		data.addLast(value);
		
		return data;		
	}
	
	
	//添加新的key
	public GDCEntity put(GDCEntity data,String key,String value) {
				
		data.addLast(key+"="+value);
		
		return data;		
	}
	
	//修改value
	public GDCEntity set(GDCEntity data,String key,String value) {
		
		
		while(data.next()){
			
			if(data.get().contains(key+"=")){
				
				
				data.set(key+"="+value);
				
			}
				
		}
		
		data.reset();
		
		return data;
		
	}
	
	
	//删除
	public GDCEntity remove(GDCEntity data,String key) {
		
		
		while(data.next()){
			
			if(data.get().contains(key+"=")){
				
				data.remove();
				
			}
				
		}
		
		data.reset();
		
		return data;
		
	}
	
	//查询
	public String get(GDCEntity data,String key) {
		
		while(data.next()){
			
			if(data.get().contains(key+"=")){
				
				String str = data.get().replace(key+"=", "");
				
				data.reset();
				
				return str;
				
			}
				
		}
		
		DataCore.LogManager.logWarning("文件系统错误! 未找到Key - "+key);
		
		return null;
		
	}
	
	
	
	//返回文件中有多少行与Match相同的字符串
	public int getRepeat(GDCEntity data,String Match){
		
		int count=0;
				
		while(data.next()){
					
			if(data.get().equals(Match)){
				count++;
			}	
			
		}
	
		return count;

	}
	
	
}
