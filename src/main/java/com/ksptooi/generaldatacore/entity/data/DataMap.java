package com.ksptooi.generaldatacore.entity.data;

import java.util.ArrayList;
import com.ksptooi.generaldatacore.common.Type;
import com.ksptooi.generaldatacore.dataInteface.DataInterface;
import com.ksptooi.generaldatacore.parser.KVParser;
import com.ksptooi.generaldatacore.parser.ListParser;

public class DataMap{

	
	private ArrayList<String> datalist = null;
	
	private DataInterface dataInterface = null;
	
	private boolean autoMaticRead = false;
	
	private boolean autoMaticWrite = false;
	
	public DataMap(DataInterface data,ArrayList<String> al){
		this.dataInterface = data;
		this.datalist = al;
	}
	
	
	public DataMap(DataInterface data,ArrayList<String> al,boolean isAutoReload,boolean isAutoUpdate){
		this.dataInterface = data;
		this.datalist = al;
		this.autoMaticRead = isAutoReload;
		this.autoMaticWrite = isAutoUpdate;
	}
	
	
	
	
	/**
	 * 重新从文件读取数据
	 */
	public void read() {
		this.datalist = dataInterface.getList();
	}
	
	/**
	 * 写数据到文件
	 */
	public void write() {
		this.dataInterface.setDataMap(this);
	}
	
	
	
	/**
	 * 获取所有内容的字符串
	 */
	public String string() {
		return ListParser.string(this.datalist);
	}
	
	
	/**
	 * 找到key的所在行
	 */
	public int indexOf(String inputKey) {
		return ListParser.indexOf(inputKey, this.datalist);
	}
	
	
	/**
	 * 根据key获取value
	 * @return 
	 * @return 
	 */
	public String getVal(String inputKey){

		//自动读取
		if(autoMaticRead) {
			this.read();
		}
		
		int line = this.indexOf(inputKey);
		
		if(line == -1) {
			return null;
		}
		
		return KVParser.value(datalist.get(line-1));	
	}
	
	/**
	 * 根据key设置value
	 */
	public boolean setVal(String key,String value) {
		
		int line = this.indexOf(key)-1;
		
		if(line == -1) {
			return false;
		}
		
		String setValue = KVParser.setValue(datalist.get(line), value);
		datalist.set(line, setValue);
		
		
		//自动写入
		if(autoMaticWrite) {
			this.write();
		}
		
		return true;	
	}
	
	
	public boolean setVal(String key,Object object) {
		return this.setVal(key, object.toString());
	}
	
	
	public Integer getInt(String k) {		
		String val = this.getVal(k);
		return Type.toInt(val);
	}
	
	public Double getDouble(String k) {
		String val = this.getVal(k);
		return Type.toDouble(val);
	}
	
	public Float getFloat(String k) {
		String val = this.getVal(k);
		return Type.toFloat(val);
	}
	
	public Boolean getBoolean(String k) {
		String val = this.getVal(k);
		return Type.toBoolean(val);
	}




	public void setAutoMaticRead(boolean autoMaticRead) {
		this.autoMaticRead = autoMaticRead;
	}



	public void setAutoMaticWrite(boolean autoMaticWrite) {
		this.autoMaticWrite = autoMaticWrite;
	}
	
	
	

}
