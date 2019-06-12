package com.ksptooi.gdc.FileDAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ishiyamasayuri.Entity.GDCEntity;
import com.ksptooi.gdc.Main.DataCore;

public class GeneralFileIO {

	
	
	//从文件获取GDC实体
	public GDCEntity getGDCEntity(File File){
		
		ArrayList<String> List=new ArrayList<String>();
		
		try{
			
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(File),"UTF-8"));
			
			String line=null;
			
			while((line=br.readLine()) != null){
				
				List.add(line);
				
			}
			br.close();
			
			return new GDCEntity(List);
				
			
		}catch(Exception e){
			e.printStackTrace();
			DataCore.LogManager.sendError("文件系统错误 at getFileContent");
		}
			
		
		return new GDCEntity(List);
		
	}
	
	
	//写GDC实体至文件
	public void writeFile(File file,GDCEntity entity){
		
		entity.reset();
		
		try{
			
			PrintWriter pw=new PrintWriter(file,"UTF-8");
						
			String content="";
			
			content = entity.getFirst();
			
			while(entity.next()){
				
				content=content+"\r\n"+entity.get();
				
			}
			
			pw.println(content);		
			
			pw.flush();
			pw.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			DataCore.LogManager.sendError("文件系统错误 at writeToFile");
		}	
		
		
	}
	
	
	
	
	
	
}
