package com.ksptooi.generaldatacore.entity.data;

import java.util.ArrayList;
import com.ksptooi.generaldatacore.common.Type;
import com.ksptooi.generaldatacore.dataInteface.DataConnection;
import com.ksptooi.generaldatacore.parser.KVParser;
import com.ksptooi.generaldatacore.parser.ListParser;

public class DataSet {

	//数据缓存
	private ArrayList<String> dataStringCache = null;

	//数据接口
	private DataConnection dataConnection = null;

	//自动读取文件
	private boolean automaticRead = false;

	//自动写入文件
	private boolean automaticWrite = false;

	//只读DataSet
	private boolean onlyRead = false;


	public DataSet(DataConnection data, ArrayList<String> al){
		this.dataConnection = data;
		this.dataStringCache = al;
	}
	
	public DataSet(DataConnection data, ArrayList<String> al, boolean isAutoReload, boolean isAutoUpdate){
		this.dataConnection = data;
		this.dataStringCache = al;
		this.automaticRead = isAutoReload;
		this.automaticWrite = isAutoUpdate;
	}


	/**
	 * 重新从文件读取数据
	 */
	public void read() {

		//System.out.println(dataConnection.isSupportRead());

		//判断数据连接是否还支持读取
		if(!dataConnection.isSupportRead()){
			System.out.println("dataConnection is not Support Read again");
			return;
		}

		this.dataStringCache = dataConnection.getStringList();
	}
	
	/**
	 * 写数据到文件
	 */
	public void write() {

		//当前DataSet是否为只读
		if(onlyRead == true){
			throw new RuntimeException("this Dataset is Only-Read ");
		}

		//判断数据连接是否还支持读取
		if(!dataConnection.isSupportWrite()){
			System.out.println("dataConnection is not Support Read again");
			return;
		}

		this.dataConnection.setDataSet(this);
	}
	
	
	
	/**
	 * 获取所有内容的字符串
	 */
	@Override
	public String toString() {
		return ListParser.string(this.dataStringCache);
	}
	
	
	/**
	 * 找到key的所在行
	 */
	public int indexOf(String inputKey) {
		return ListParser.indexOf(inputKey, this.dataStringCache);
	}
	
	
	/**
	 * 根据key获取value
	 * @return 
	 * @return 
	 */
	public String getVal(String inputKey){

		//自动读取
		this.update("read");
		
		int line = this.indexOf(inputKey);
		
		if(line == -1) {
			return null;
		}
		
		return KVParser.value(dataStringCache.get(line-1));
	}

	public String val(String inputKey){
		return this.getVal(inputKey);
	}
	
	/**
	 * 根据key设置value
	 */
	public boolean setVal(String key,String value) {

		//当前DataSet是否为只读
		if(onlyRead == true){
			throw new RuntimeException("cant Write,this Dataset is Only-Read ");
		}

		//更新数据
		update("read");

		int line = this.indexOf(key)-1;

		//如果没有数据则添加一条key
		if(line < 1) {
			this.dataStringCache.add(KVParser.format(key,value));
			update("write");
			return false;
		}
		
		String setValue = KVParser.setValue(dataStringCache.get(line), value);
		dataStringCache.set(line, setValue);
		
		
		//自动写入
		update("write");
		
		return true;
	}
	
	
	public boolean setVal(String key,Object object) {
		return this.setVal(key, object.toString());
	}

	/**
	 * 存入字符串集合
	 */
	public boolean setVal(String key,ArrayList<String> object) {
		return this.setVal(key,KVParser.listToString(object));
	}

	//存入字符串集合
	public boolean val(String key,ArrayList<String> object) {
		return this.setVal(key,KVParser.listToString(object));
	}

	public boolean val(String key,Object object){
		return this.setVal(key,object);
	}

	public Integer getInt(String k) {
		return Type.toInt(this.getVal(k));
	}
	
	public Double getDouble(String k) {
		return Type.toDouble(this.getVal(k));
	}
	
	public Float getFloat(String k) {
		return Type.toFloat(this.getVal(k));
	}
	
	public Boolean getBoolean(String k) {
		return Type.toBoolean(this.getVal(k));
	}

	/**
	 * 取出字符串集合
	 */
	public ArrayList<String> getList(String k){
		String val = this.getVal(k);
		return KVParser.stringToList(val);
	}


	public DataSet setAutomaticRead(boolean automaticRead) {
		this.automaticRead = automaticRead;
		return this;
	}

	public DataSet setAutomaticWrite(boolean automaticWrite) {
		this.automaticWrite = automaticWrite;
		return this;
	}

	public DataSet setAutomatic(boolean b){
		this.automaticRead = b;
		this.automaticWrite = b;
		return this;
	}

	public boolean isOnlyRead() {
		return onlyRead;
	}

	public void setOnlyRead(boolean onlyRead) {
		this.onlyRead = onlyRead;
	}

	//更新数据
	private void update(String type){

		//判断类型为读 并且开启自动读取
		if(type.equalsIgnoreCase("read") && this.automaticRead == true){
			this.read();
			return;
		}

		if(type.equalsIgnoreCase("write") && this.automaticWrite == true){
			this.write();
			return;
		}

		//判断类型错误
		if(!type.equalsIgnoreCase("read") && !type.equalsIgnoreCase("write")){
			throw new RuntimeException("the type does not match ,correct type is 'read' and 'write' ");
		}


	}

}
