package com.ksptooi.gdc.v6.Manager;

import java.io.File;

import com.ksptooi.gdc.File.Process.FileProcess;
import com.ksptooi.gdc.v5.Manager.IOController_V5;

public class DataManager extends IOController_V5{
	
	
	FileProcess FP=null;
	File Target=null;
	
	String SeparationSymbol="=";
	
	public DataManager() {
		this.FP = new FileProcess();
	}
	
	
	/**
	 * 设置一个目标文件,在之后所有的文件访问都将针对于这个目标文件.
	 * 
	 * @param f 目标文件实例
	 */
	public void setTarget(File f) {		
		super.setTarget(f);
		this.Target = f;
	}
	
	public File getTarget() {
		return Target;
	}
	
	
	
	/**
	 * 用于创建一个新的GD文件.
	 * 
	 * @return 当文件创建失败时会返回False,反之为True 
	 * @param f 文件实例
	 */
	public boolean createGdc(File f){
		
		return FP.createNewGdcFileProcess(f);
		
	}
	
	/**
	 * 向一个GD文件中加入一行新的内容,依赖于设置的Target.
	 * @param Line 将要添加的内容
	 */
	public void addLine(String Line){
		
		FP.addLineProcess(Target, Line);
		
	}
	
	
	/**
	 * 获取一个GDC文件中的所有内容
	 * @return 内容
	 */
	public String getAll(){
		return FP.getFileContentProcess(Target);
	}
	
	
	/**
	 * 获取一个GDC文件中所有与之相匹配内容的数量
	 * @return Match 要匹配的内容
	 */
	public int getRepeatLineCount(String Match) {
		return FP.getRepeatLineCountProcess(Target, Match);
	}
	
	/**
	 * 覆盖写入至GD文件
	 * @param Content 要覆写的内容
	 */
	public void setContent(String Content) {
		FP.setFileContentProcess(Target, Content);
	}
	
	/**
	 * 设置GD文件中指定Key的值
	 * @param key 要查找的key
	 * @param value 要设置的值
	 */
	public void setKey(String key,String value){
		
		FP.setKeyValueProcess(Target, key, value, this.SeparationSymbol);
		
	}
	
	/**
	 * 获取GD文件中指定Key的值
	 * @param key 要查找的key
	 * @return 当前key的值
	 */
	public String getKey(String key){
		
		return FP.getKeyValueProcess(Target, key, this.SeparationSymbol);
		
	}
	
	/**
	 * 获取GD文件中指定Key的值 int类型
	 * @param key 要查找的key
	 * @return 当前key的值
	 */
	public int getKeyForInt(String key){
		
		return FP.getKeyValueForIntProcess(Target, key, this.SeparationSymbol);
		
	}
	
	/**
	 * 获取GD文件中指定Key的值 double类型
	 * @param key 要查找的key
	 * @return 当前key的值
	 */
	public double getKeyForDouble(String key){
		
		return FP.getKeyValueForDoubleProcess(Target, key, this.SeparationSymbol);
		
	}
	
	/**
	 * 添加一个新的key与值到GD文件
	 * @param key 要添加的key
	 * @param value key的值
	 */
	public void put(String key,String value){
		
		FP.putProcess(Target, key, value, this.SeparationSymbol);
		
	}
	
	/**
	 * 从GD文件删除一个key
	 * @param key 要删除的key
	 */
	public void remove(String key){
		
		FP.removeProcess(Target, key);
		
	}
	
	
	
}
