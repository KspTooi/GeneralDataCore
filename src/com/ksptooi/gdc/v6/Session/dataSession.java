package com.ksptooi.gdc.v6.Session;

import java.io.File;
import java.util.ArrayList;
import com.ksptooi.gdc.Entity.GDCEntity;
import com.ksptooi.gdc.Main.gdcList;
import com.ksptooi.gdc.v6.Factory.DataSessionFactory;
import com.ksptooi.gdc.v6.FileIO.GeneralFileIO;
import com.ksptooi.gdc.v6.FileProcess.dataProcess;

public class dataSession{

	//IO
	GeneralFileIO io= new GeneralFileIO();
	
	private boolean isChange=false;
	
	//数据缓存
	GDCEntity data=null;
	
	//数据源
	private File dataSources=null;
	
	//Factory
	private DataSessionFactory fromFactory=null;
	
	private boolean isRelease=true;
	
	//Process
	dataProcess process=new dataProcess();
	
	
	//构造
	public dataSession(DataSessionFactory fromFactory){
		
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
	public void assign(DataSessionFactory df,File dataSources) {
		
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
		
		data = io.getGDCEntity(this.dataSources);
		
	}
	
	
	//释放
	public void release() {
		
		
		if(isChange) {
			io.writeGDCEntity(dataSources, data);
			System.out.println("进行写入");
		}	
		
		data = null;
		dataSources = null;
		
		this.isRelease=true;
		this.isChange=false;
		
		fromFactory.getListDataSession().add(this);
		
		System.out.println("释放Session:"+this);
		
		System.out.println("Session池大小:"+fromFactory.getListDataSession().size());
		
	}
	
	//判断是否能执行
	private boolean isRelease() {
		
		if(this.isRelease) {
			throw new RuntimeException("该Session已被释放.");	
		}
		
		return false;
	}
	
	
	//添加新的Key 与Value
	public void put(String key,String value) {	
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.data=process.put(data, key, value);
	
	}
	
	public void put(String key,ArrayList<String> value) {
		
		if(isRelease()) {
			return;
		}
		
		gdcList list=new gdcList(value);
		
		this.put(key, list.toString());
	}
		
	public void put(String key,double value) {
		
		if(isRelease()) {
			return;
		}
		
		this.put(key, String.valueOf(value));
		
	}
	
	public void put(String key,int value) {
		if(isRelease()) {
			return;
		}
		
		this.put(key, String.valueOf(value));
	}
	
	
	public void addline(String value) {
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		process.addline(data, value);
		
	}
			
	
	
	//修改key的value
	public void set(String key,String value) {
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.data=process.set(this.data, key, value);
		
	}
	
	public void set(String key,int value) {
		
		if(isRelease()) {
			return;
		}
		
		this.set(key, String.valueOf(value));
		
	}
	
	public void set(String key,double value) {
		
		if(isRelease()) {
			return;
		}
		
		this.set(key, String.valueOf(value));
		
	}
	
	public void set(String key,ArrayList<String> value) {
		
		if(isRelease()) {
			return;
		}
		
		gdcList list = new gdcList(value);
		
		this.set(key, list.toString());
		
	}
	
	
	//删除
	public void remove(String key) {
		
		if(isRelease()) {
			return;
		}
		
		isChange=true;
		
		this.data=process.remove(this.data, key);
	}
	
	
	//查询
	public String get(String key) {
		
		if(isRelease()) {
			return null;
		}
		
		return process.get(data, key);
		
	}
	
	public int getInt(String key) {
		
		if(isRelease()) {
			return -1;
		}
		
		String str = this.get(key);
			
		return new Integer(str);
	}
	
	public double getDouble(String key) {
		
		if(isRelease()) {
			return -1;
		}
		
		String str = this.get(key);
		
		return Double.valueOf(str);
	}
	
	public ArrayList<String> getList(String key) {
		
		if(isRelease()) {
			return null;
		}
		
		String str = this.get(key);
		
		gdcList list=new gdcList(str);
		
		return list.toArrayList();
	}
	
	
	
	public int getRepeat(String Match) {
		
		if(isRelease()) {
			return -1;
		}
		
		return process.getRepeat(data, Match);
		
	}
	
	
	
}
