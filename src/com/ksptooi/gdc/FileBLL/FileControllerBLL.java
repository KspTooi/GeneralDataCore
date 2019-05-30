package com.ksptooi.gdc.FileBLL;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import com.ksptooi.gdc.FileDAL.FileDAL_Input;
import com.ksptooi.gdc.FileDAL.FileDAL_OutPut;
import com.ksptooi.gdc.Util.Var;

public class FileControllerBLL{

	FileDAL_Input fileDAL_Input=null;
	FileDAL_OutPut fileDAL_OutPut=null;
	
	public FileControllerBLL(){
		fileDAL_Input=new FileDAL_Input();
		fileDAL_OutPut=new FileDAL_OutPut();
	}
	
	
	//获取文件中Key值的内容
	public String getKeyValue_FileBLL(File File,String Key,String SeparationSymbol){
	
		String result=null;
		
		//判断文件是否为空
		if(File == null){
			return "File Is Null";
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			return "File not found";
		}
		
		
		result=fileDAL_Input.getFileKeyLine(File, Key,SeparationSymbol);
		
		
		if(result == null){
			return null;
		}
		
		return result.replace(Key+SeparationSymbol, "");
		
	}
	
	
	//设置文件中Key值的内容
	public void setKeyValue_FileBLL(File File,String Key,String Value,String SeparationSymbol){
		
		//判断文件是否为空
		if(File == null){
			Var.LogManager.writeLogOfError("文件系统错误 - Target为null");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			Var.LogManager.writeLogOfError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
			return;
		}
		
		
		fileDAL_OutPut.modifyKeyValue(File, Key, Value,SeparationSymbol);
		
		
	}
	
	
	//覆盖写入
	public void setFileContent_FileBLL(File File,String Content){
		
		//判断文件是否为空
		if(File == null){
			Var.LogManager.writeLogOfError("文件系统错误 - Target为null");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			Var.LogManager.writeLogOfError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
			return;
		}
		
		fileDAL_OutPut.writeToFile(File, Content);
		
	}
	
	
	//返回文件中有多少行与Match相同的字符串
	public int getRepeatLineCount_FileBLL(File File,String Match){
		
		ArrayList<String> List=null;
		
		//判断文件是否为空
		if(File == null){
			Var.LogManager.writeLogOfError("文件系统错误 - Target为null");
			return -1;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			Var.LogManager.writeLogOfError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
			return -1;
		}
		
		
		List = fileDAL_Input.getFileContentList(File);
		
		int count=0;
		
		
		for(String str:List){
			
			if(str.equals(Match)){
				count++;
			}
			
		}
		
	
		return count;

	}
	
	//获取文件中的所有内容
	public String getFileContent_FileBLL(File File){
		
		//判断文件是否为空
		if(File == null){
			return "File Is Null";
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			return "File not found";
		}
		
		
		return fileDAL_Input.getFileContent(File);
		
	}
	
	//向文件中添加一行内容
	public void addLine_FileBLL(File File,String Content){
		
		//判断文件是否为空
		if(File == null){
			Var.LogManager.writeLogOfError("文件系统错误 - Target为null");
			return;
		}
		
		//判断文件是否存在
		if( ! File.exists()){
			Var.LogManager.writeLogOfError("文件系统错误 - 文件未找到  - setKeyValue_FileBLL");
			return;
		}
		
		
		fileDAL_OutPut.addToFile(File,  "\r\n" +Content + "\r\n");
		
	}
	
	
	
	//创建一个新的gdc文件
	public boolean createNewGdcFile_BLL(File File){
		
		if(File.exists()){
			return false;
		}
		
		
		try {
				
			File.getParentFile().mkdirs();
			File.createNewFile();
			this.addLine_FileBLL(File, "@LineType=GeneralDataCore");
			this.addLine_FileBLL(File, "@LineVersion=V5");
			this.addLine_FileBLL(File, "@KeySeparationSymbol==");
			this.addLine_FileBLL(File, "#	");
			
		} catch (IOException e) {
			e.printStackTrace();
			Var.LogManager.writeLogOfError("严重·出现未知的文件系统错误！- createNewGdcFile_BLL");
			return false;
		}
		
		return true;
		
	}


	public String getKeyValueOfInputStream_FileBLL(InputStream is, String key, String separationSymbol) {
		
		
		String result=null;		
		
		
		result=fileDAL_Input.getFileKeyLineOfInputStream(is, key,separationSymbol);
		
		
		if(result == null){
			return null;
		}
		
		return result.replace(key+separationSymbol, "");
		
		
	}
	
	

	
	
	
	
	
}
