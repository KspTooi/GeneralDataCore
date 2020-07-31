package uk.iksp.v7.session.gdata;

import java.io.File;
import java.util.ArrayList;
import com.ksptooi.v3.Entity.GeneralDataListEntity;
import com.ksptooi.v3.Entity.KeyList;

import uk.iksp.v7.session.common.AbstractGDataSession;
import uk.iksp.v7.session.factory.DataSessionFactory;

public class GDataSession extends AbstractGDataSession{

	
	private boolean isChange=false;
	
	
	//数据源 - 文件
	private File dataSources=null;
	
	

	/**公用方法*/	
	 
	
	//构造
	public GDataSession(DataSessionFactory fromFactory){
		
		this.fromFactory=fromFactory;
		
		//判断Factory是否为空
		if(this.fromFactory == null) {
			throw new RuntimeException("DataFactory is null");
		}
		
		//判断Factory是否是really
		if(!(this.fromFactory instanceof DataSessionFactory)) {
			throw new RuntimeException("DataFactory is not really");
		}
		
		
	}
	
	//分配
	public synchronized void assign(DataSessionFactory df,File dataSources) {
		
		if(this.fromFactory == null) {
			throw new RuntimeException("DataFactory is null");
		}
		
		if(!(this.fromFactory instanceof DataSessionFactory)) {
			throw new RuntimeException("DataFactory is not really");
		}
		
		this.isRelease=false;
		
		//如果文件不存在则收回该Session
		if(!dataSources.exists()) {
			this.release();
			throw new RuntimeException("没有找到该文件.");
		}
		
			
		//加载数据源
		this.dataSources=dataSources;
		
		dataCache = io.getGeneralDataEntity(this.dataSources);
		
	}
	
	
	//释放
	public synchronized void release(){
		
		
		if(isChange) {
			io.updateGeneralDataEntity(dataSources, dataCache);
		}	
		
		dataCache = null;
		dataSources = null;
		
		this.isRelease=true;
		this.isChange=false;
//		System.out.println(fromFactory.getListDataSession().size());
		fromFactory.getListDataSession().add(this);
		
	}
	
	
	
	@Override
	public void close() {
		this.release();	
	}
	
	
	/**公用方法 -结束*/	
	
	
	
	

			

	
	/**
	 * 
	 * 增加
	 *
	 **/
	
	//添加新的Key 与Value
	public void put(String key,String value) {	
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.dataCache.put(key, value);
	
	}
	
	public void put(String key,ArrayList<String> value) {	
		GeneralDataListEntity list=new GeneralDataListEntity(value);	
		this.put(key, list.toString());
	}
		
	public void put(String key,double value) {	
		this.put(key, String.valueOf(value));	
	}
	
	public void put(String key,int value) {
		this.put(key, String.valueOf(value));
	}
	
	public void put(String key,boolean value) {
		this.put(key, String.valueOf(value));			
	}
	
	public void put(String key,float value) {
		this.put(key, String.valueOf(value));			
	}
	
	
	
	public void addline(String value) {
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.dataCache.addline(value);	
	}
	
	
	
	
	/**
	 * 
	 * 修改
	 *
	 **/
	
	public void set(String key,String value) {
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.dataCache.set(key, value);
		
	}
	
	public void set(String key,int value) {		
		this.set(key, String.valueOf(value));	
	}
	
	public void set(String key,double value) {
		this.set(key, String.valueOf(value));	
	}
	
	public void set(String key,ArrayList<String> value) {
		GeneralDataListEntity list = new GeneralDataListEntity(value);
		this.set(key, list.toString());	
	}
	
	public void set(String key,boolean value) {
		this.set(key, String.valueOf(value));	
	}
	
	public void set(String key,float value) {
		this.set(key, String.valueOf(value));	
	}
	
	//修改行列表
	public void set(KeyList keyList){
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.dataCache.setKeyList(keyList);
	}
	
	
	
	/**
	 * 
	 * 删除
	 *
	 **/
	public void remove(String key) {
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.dataCache.remove(key);
	}
	

	
	
	
	
	/**
	 * 
	 * 查询
	 *
	 **/
	
	//查询
	public String get(String key) {
		
		
		if(isRelease()) {
			return null;
		}
		
		return this.dataCache.get(key);	
		
	}
	
	public int getInt(String key) {
		
		String str = this.get(key);			
		return new Integer(str);
	}
	
	public double getDouble(String key) {
		String str = this.get(key);
		return Double.valueOf(str);
	}
	
	public ArrayList<String> getList(String key) {
				
		String str = this.get(key);		
		GeneralDataListEntity list=new GeneralDataListEntity(str);		
		return list.toArrayList();
	}
	
	
	public Boolean getBoolean(String key) {
		
		String str = this.get(key);		
		return Boolean.valueOf(str);
	}
	
	public Float getFloat(String key) {
		
		String str = this.get(key);		
		return Float.valueOf(str);
	}
	
	public int getRepeat(String Match) {
		
		if(isRelease()) {
			return -1;
		}
		return this.dataCache.getRepeat(Match);	
	}
	
	
	public ArrayList<String> getLine(){
		
		if(isRelease()) {
			return null;
		}
		
		ArrayList<String> al=new ArrayList<String>();
		
		
		//循环取出data中的内容
		

		while(this.dataCache.next()){
			
			al.add(this.dataCache.get());
			
		}
		
		
		return al;
		
	}
	
	
	//直接获取所有行内容
	public ArrayList<String> getAll(){
		
		ArrayList<String> als=new ArrayList<String>();
		
		
		while(dataCache.next()) {
			
			als.add(dataCache.get());
			
		}
		
		
		return als;
		
	}
	
	//获取行列表
	public KeyList getKeyList(String key){
		
		return this.dataCache.getKeyList(key);	
		
	}

	
	
	
	
}
