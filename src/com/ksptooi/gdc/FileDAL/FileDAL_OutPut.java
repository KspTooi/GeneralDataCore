package com.ksptooi.gdc.FileDAL;

import java.io.File;
import java.io.PrintWriter;

import com.ksptooi.gdc.Util.Var;

public class FileDAL_OutPut {

	
	FileDAL_Input inpDAL=new FileDAL_Input();
	
	
	//将指定内容写入文件(覆盖)
	public boolean writeToFile(File File,String Content){
		
		try{
			
			PrintWriter pw=new PrintWriter(File,"UTF-8");
			
			pw.println(Content);
			pw.flush();
			pw.close();
			
			return true;
			
			
		}catch(Exception e){
			e.printStackTrace();
			Var.LogManager.writeLogOfError("文件系统错误 at writeToFile");
		}
		
		return false;
		
	}
	
	
	//将指定内容添加到文件中
	public boolean addToFile(File File,String addContent){
		
		
		String fileOldContent=null;
		
		String fileNewContent=addContent;
		
			
		fileOldContent=inpDAL.getFileContent(File);
			
		
		if(this.writeToFile(File, fileOldContent+fileNewContent)==true){
			return true;
		}

			
		return false;

	}
	
	
	
	//修改key值的内容
	public void modifyKeyValue(File File , String Key , String newContent,String SeparationSymbol){
		
		String allContent=inpDAL.getFileContent(File);
		
		String oldKeyLine=inpDAL.getFileKeyLine(File, Key,SeparationSymbol);
		
		String newKeyLine=Key+SeparationSymbol+newContent;
		
		
		try{
			
			this.writeToFile(File, allContent.replace(oldKeyLine, newKeyLine));
			
		}catch (NullPointerException e){
			Var.LogManager.writeLogOfError("文件系统错误! - Key未找到("+Key+") - modifyKeyValue");
			Var.LogManager.writeLogOfWarning("未能执行文件更新");
		}
		
		
	}
	
	
	
	
}
