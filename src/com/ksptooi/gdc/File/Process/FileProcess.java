package com.ksptooi.gdc.File.Process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.ishiyamasayuri.gdc.Entity.GDCEntity;
import com.ksptooi.gdc.FileDAL.GeneralFileIO;
import com.ksptooi.gdc.Main.DataCore;

public class FileProcess{

	GeneralFileIO GFI=new GeneralFileIO();
	
	public FileProcess(){
		GFI=new GeneralFileIO();
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
	
	
	//设置文件中Key值的内容
	public void setKeyValueProcess(File File,String Key,String Value,String SeparationSymbol){
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.sendError("文件系统错误 - Target为null");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.sendError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
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
		
		GFI.writeFile(File, GDCE);
		
		
	}
	
	
	//覆盖写入
	public void setFileContentProcess(File File,String Content){
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.sendError("文件系统错误 - Target为null");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.sendError("文件系统错误 - 文件未找到  - setFileContentProcess");
			return;
		}
		
		
		GFI.writeFile(File, Content);
		
	}
	
	
	//返回文件中有多少行与Match相同的字符串
	public int getRepeatLineCountProcess(File File,String Match){
		
		GDCEntity GDCE = null;
		
		//判断文件是否为空
		if(File == null){
			DataCore.LogManager.sendError("文件系统错误 - Target为null");
			return -1;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.sendError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
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
			DataCore.LogManager.sendError("文件系统错误 - Target为null");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			DataCore.LogManager.sendError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
			return;
		}
		
		GDCEntity GDCE = null;
		
		GDCE=GFI.getGDCEntity(File);
		
		GDCE.addLast(Content);
		
		GDCE.reset();
		
		while(GDCE.next()){
			System.out.println("||"+GDCE.get());
		}
		
		
		GFI.writeFile(File, GDCE);
		
	}
	
	
	
	//创建一个新的gdc文件
	public boolean createNewGdcFileProcess(File File){
		
		if(File.exists()){
			return false;
		}
		
		
		try {
				
			File.getParentFile().mkdirs();
			File.createNewFile();
			this.addLineProcess(File, "@LineType=GeneralDataCore");
			this.addLineProcess(File, "@LineVersion=V5");
			this.addLineProcess(File, "@KeySeparationSymbol==");
			this.addLineProcess(File, "#	");
			
		} catch (IOException e) {
			e.printStackTrace();
			DataCore.LogManager.sendError("严重·出现未知的文件系统错误！- createNewGdcFile_BLL");
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
