package com.ksptooi.gdc.FileAPI;

import java.io.File;
import java.io.InputStream;

import com.ksptooi.gdc.FileBLL.FileControllerBLL;
import com.ksptooi.gdc.Util.Var;


public class IOController_V5 {

	private File Target=null;
	
	private String SeparationSymbol="=";
	
	private FileControllerBLL fileControllerBLL=null;
	
	
	//构造方法
	public IOController_V5(){
		
		fileControllerBLL=new FileControllerBLL();
		
	}
	
	
	public File getTarget() {
		return Target;
	}

	public void setTarget(File target) {
		Target = target;
	}

	
	public String test(){
		Var.LogManager.writeLogOfINFO("版本:"+Var.gdc_Version);
		return Var.gdc_Version;
	}
	
	
	
	//获取文件中Key值的内容
	public String getKeyValue(String Key){
		
		return fileControllerBLL.getKeyValue_FileBLL(Target, Key,SeparationSymbol);
		
	}
	
	
	
	//设置文件中Key值的内容
	public void setKeyValue(String Key,String Value){
		
		fileControllerBLL.setKeyValue_FileBLL(Target, Key, Value,SeparationSymbol);
		
	}
	
	
	//覆盖写入
	public void setFileContent(String Content){
		
		fileControllerBLL.setFileContent_FileBLL(Target, Content);
		
	}
	
	
	//返回文件中有多少行与Match相同的字符串
	public int getRepeatLineCount(String Match){
		
		return fileControllerBLL.getRepeatLineCount_FileBLL(Target, Match);
		
	}
	
	//获取文件中的所有内容
	public String getFileContent(){
		
		return fileControllerBLL.getFileContent_FileBLL(Target);
		
	}
	
	//向文件中添加一行内容
	public void addLine(String Content){
		
		fileControllerBLL.addLine_FileBLL(Target, Content);
	}
	
	//创建一个新的gdc文件
	public boolean createNewGdcFile(File File){
		
		return fileControllerBLL.createNewGdcFile_BLL(File);
		
	}
	
	
	
	//获取文件中Key值的内容 通过InputStream
	public String getKeyValueOfInputStream(InputStream is,String Key){
		
		return fileControllerBLL.getKeyValueOfInputStream_FileBLL(is, Key,SeparationSymbol);
		
	}
	
	
	
}
