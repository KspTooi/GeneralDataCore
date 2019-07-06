package com.ksptooi.gdc.v5.Manager;

import java.io.File;
import java.io.InputStream;

import com.ksptooi.gdc.File.Process.FileProcess;
import com.ksptooi.gdc.Main.DataCore;


public class IOController_V5 {

	private File Target=null;
	
	private String SeparationSymbol="=";
	
	private FileProcess fileProcess=null;
	
	
	//构造方法
	public IOController_V5(){
		
		fileProcess=new FileProcess();
		
	}
	
	
	public File getTarget() {
		return Target;
	}

	public void setTarget(File target) {
		Target = target;
	}

	
	public String test(){
		DataCore.LogManager.logInfo("版本:"+DataCore.gdc_Version);
		return DataCore.gdc_Version;
	}
	
	
	
	//获取文件中Key值的内容
	public String getKeyValue(String Key){
		
		return fileProcess.getKeyValueProcess(Target, Key,SeparationSymbol);
		
	}
	
	//设置文件中Key值的内容
	public void setKeyValue(String Key,String Value){
		
		fileProcess.setKeyValueProcess(Target, Key, Value,SeparationSymbol);
		
	}
	
	
	//覆盖写入
	public void setFileContent(String Content){
		
		fileProcess.setFileContentProcess(Target, Content);
		
	}
	
	
	//返回文件中有多少行与Match相同的字符串
	public int getRepeatLineCount(String Match){
		
		return fileProcess.getRepeatLineCountProcess(Target, Match);
		
	}
	
	//获取文件中的所有内容
	public String getFileContent(){
		
		return fileProcess.getFileContentProcess(Target);
		
	}
	
	//向文件中添加一行内容
	public void addLine(String Content){
		
		fileProcess.addLineProcess(Target, Content);
	}
	
	//创建一个新的gdc文件
	public boolean createNewGdcFile(File File){
		
		return fileProcess.createNewGdcFileProcess(File);
		
	}
	
	
	//获取文件中Key值的内容 通过InputStream
	public String getKeyValueOfInputStream(InputStream is,String Key){
		
		return fileProcess.getKeyValueOfInputStreamProcess(is, Key,SeparationSymbol);
		
	}
	
	
	
}
