package com.ksptooi.gdc.v6.FileProcess;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.ksptooi.gdc.Entity.GDCEntity;
import com.ksptooi.gdc.Main.DataCore;
import com.ksptooi.gdc.Main.gdcList;
import com.ksptooi.gdc.v6.FileIO.GeneralFileIO;

public class FileProcess{

	GeneralFileIO GFI=new GeneralFileIO();
	
	public FileProcess(){
		GFI=new GeneralFileIO();
	}
	
	
	
	//添加新的List Key
	public void putProcess(File Target,String key,ArrayList<String> value,String SeparationSymbol) {
		
		
		gdcList list=new gdcList(value);
		
		this.putProcess(Target, key, list.toString(), SeparationSymbol);
		
	}
	
	
	//获取指定key下的list
	public ArrayList<String> getListFromKeyProcess(File file,String key,String SeparationSymbol) {
		
		String keyValue = this.getKeyValueProcess(file, key, SeparationSymbol);
		
		
		try {
			
		
			gdcList list=new gdcList(keyValue);
			
			return list.toArrayList();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
			
		
	}
	
	
	
	//删除一个key
	public void removeProcess(File Target,String key) {
		
		//判断文件是否为空
		if(Target == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return;
		}
		
		//判断文件是否存在
		if( ! Target.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:putProcess");
			return;
		}
		
		GDCEntity GDCE=GFI.getGDCEntity(Target);
		
		while(GDCE.next()){
			
			
			if(GDCE.get().split("=")[0].equals(key)){
				GDCE.remove();
				break;
			}		
			
		}
		
		GFI.writeGDCEntity(Target, GDCE);
		
		
	}
	
	
	
	
	//添加新的key
	public void putProcess(File Target,String key,String value,String SeparationSymbol) {
		
		//判断文件是否为空
		if(Target == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return;
		}
		
		//判断文件是否存在
		if( ! Target.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:putProcess");
			return;
		}
		
		
		GDCEntity GDCE=GFI.getGDCEntity(Target);
		
		GDCE.addLast(key+SeparationSymbol+value);
		
		GFI.writeGDCEntity(Target, GDCE);
		
	}
	
	
	
	
	//获取文件中Key值的内容 转换为Double
	public double getKeyValueForDoubleProcess(File File,String Key,String SeparationSymbol) {
		
		
		String KV = this.getKeyValueProcess(File, Key, SeparationSymbol);
		
		try {
			
			double Double_kv = Double.valueOf(KV);
			return Double_kv;	
			
		}catch(Exception e) {
			DataCore.LogManager.logError("文件系统错误:key:"+KV+" 无法转换为int");
			return -2147483647;
		}
		
		
	}
	
	
	//获取文件中Key值的内容 转换为int
	public int getKeyValueForIntProcess(File File,String Key,String SeparationSymbol) {
		
		
		String KV = this.getKeyValueProcess(File, Key, SeparationSymbol);
		
		try {
			
			int int_kv = new Integer(KV);
			return int_kv;	
			
		}catch(Exception e) {
			DataCore.LogManager.logError("文件系统错误:key:"+KV+" 无法转换为int");
			return -2147483647;
		}
		
		
	}
	
	
	
	
	//获取文件中Key值的内容
	public String getKeyValueProcess(File File,String Key,String SeparationSymbol){
	
		GDCEntity GDCE= null;
		
		//判断文件是否为空
		if(File == null){
			return "File Is Null";
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			return "File not found";
		}
		
		//获取GDC实体
		GDCE = GFI.getGDCEntity(File);
		
		
		while(GDCE.next()){
						
			if(GDCE.get().contains(Key+SeparationSymbol)){
				return GDCE.get().replace(Key+SeparationSymbol, "");
			}		
			
		}
		
		return null;
		
	}
	
	
	
	//设置文件中Key值的内容(集合)
	public void setKeyValueProcess(File File,String Key,ArrayList<String> Value,String SeparationSymbol){
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:setKeyValueProcess");
			return;
		}
		
		//将ArrayList解析为GDCList
		gdcList list=new gdcList(Value);
		
		
		GDCEntity GDCE= null;
		
		
		//获取GDC实体
		GDCE = GFI.getGDCEntity(File);
		
		
		while(GDCE.next()){
			
			if(GDCE.get().contains(Key+SeparationSymbol)){
				
				GDCE.set(Key+SeparationSymbol+list.toString());
				
			}
			
			
		}
		
		GFI.writeGDCEntity(File, GDCE);
		
		
	}
	
	
	//设置文件中Key值的内容
	public void setKeyValueProcess(File File,String Key,String Value,String SeparationSymbol){
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:setKeyValueProcess");
			return;
		}
		
		GDCEntity GDCE= null;
		
		
		//获取GDC实体
		GDCE = GFI.getGDCEntity(File);
		
		
		while(GDCE.next()){
			
			if(GDCE.get().contains(Key+SeparationSymbol)){
				
				GDCE.set(Key+SeparationSymbol+Value);
				
			}
				
		}
		
		GFI.writeGDCEntity(File, GDCE);
		
		
	}
	
	
	//覆盖写入
	public void setFileContentProcess(File File,String Content){
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:setFileContentProcess");
			return;
		}
		
		
		GFI.writeFile(File, Content);
		
	}
	
	
	//返回文件中有多少行与Match相同的字符串
	public int getRepeatLineCountProcess(File File,String Match){
		
		GDCEntity GDCE = null;
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return -1;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:getRepeatLineCountProcess");
			return -1;
		}
		
		
		GDCE = GFI.getGDCEntity(File);
		
		int count=0;
		
		
		
		while(GDCE.next()){
					
			if(GDCE.get().equals(Match)){
				count++;
			}	
			
		}
	
		return count;

	}
	
	//获取文件中的所有内容
	public String getFileContentProcess(File File){
		
		GDCEntity GDCE = null;
		String Result="";
		
		//判断文件是否为空
		if(File == null){
			return "File Is Null";
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			return "File not found";
		}
		
		GDCE=GFI.getGDCEntity(File);
		
		
		Result = GDCE.getFirst();
		
		while(GDCE.next()){
			Result=Result + "\r\n" +GDCE.get();
		}
		
		
		return Result;
		
	}
	
	//向文件中添加一行内容
	public void addLineProcess(File File,String Content){
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.logError("文件系统错误:没有设置Target");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.logError("文件系统错误:文件未找到:addLineProcess");
			return;
		}
		
		GDCEntity GDCE = null;
		
		GDCE=GFI.getGDCEntity(File);
		
		GDCE.addLast(Content);
		
		GDCE.reset();
		
//		while(GDCE.next()){
//			System.out.println("||"+GDCE.get());
//		}
		
		
		GFI.writeGDCEntity(File, GDCE);
		
	}
	
	
	
	//创建一个新的gdc文件
	public boolean createNewGdcFileProcess(File File){
		
		if(File.exists()){
			return false;
		}
		

		
		try {
				
			File.getParentFile().mkdirs();
			File.createNewFile();
			this.addLineProcess(File, "@Type=GeneralDataCore");
			this.addLineProcess(File, "@Version=V6");
			this.addLineProcess(File, "@Symbol==");
			this.addLineProcess(File, "#	");
			
		} catch (IOException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("严重·出现未知的文件系统错误！- createNewGdcFileProcess");
			return false;
		}
		
		return true;
		
	}


	public String getKeyValueOfInputStreamProcess(InputStream is, String key, String separationSymbol) {
		
		
		String result=null;		
		
		
		result=GFI.getFileKeyLineOfInputStream(is, key,separationSymbol);
		
		
		if(result == null){
			return null;
		}
		
		return result.replace(key+separationSymbol, "");
		
		
	}
	
	
}
