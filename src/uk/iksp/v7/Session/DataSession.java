package uk.iksp.v7.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import com.ksptooi.v3.Entity.GeneralDataEntity;
import com.ksptooi.v3.Entity.GeneralDataListEntity;

import uk.iksp.v7.DataSourcesServices.DataSourcesService;
import uk.iksp.v7.DataSourcesServices.FileDataSourceIO;
import uk.iksp.v7.Factory.DataSessionFactory;

public class DataSession implements AutoCloseable {

	//IO
	FileDataSourceIO io= new FileDataSourceIO();
	
	private boolean isChange=false;
	
	//数据缓存
	GeneralDataEntity data=null;
	
	//数据源 - 文件
	private File dataSources=null;
	
	
	//数据源 - 流
	private InputStream inputStream = null;
	private OutputStream outputStream = null;
	
	
	//Factory
	private DataSessionFactory fromFactory=null;
	
	
	private boolean isRelease=true;
	
	//Process
	DataSourcesService process=new DataSourcesService();
	
	
	//构造
	public DataSession(DataSessionFactory fromFactory){
		
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
		

		
		try {
			
			//加载数据源
			this.dataSources=dataSources;
			
			this.inputStream = new FileInputStream(this.dataSources);
			
			this.outputStream = new FileOutputStream(this.dataSources);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		data = io.getGDCEntity(this.dataSources);
		
	}
	
	
	
	
	
	
	//释放
	public synchronized void release() {
		
		
		if(isChange) {
			io.writeGDCEntity(dataSources, data);
		}	
		
		data = null;
		dataSources = null;
		
		this.isRelease=true;
		this.isChange=false;
		System.out.println(fromFactory.getListDataSession().size());
		fromFactory.getListDataSession().add(this);
		
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
		
		GeneralDataListEntity list=new GeneralDataListEntity(value);
		
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
	
	public void put(String key,boolean value) {
		if(isRelease()) {
			return;
		}
		
		this.put(key, String.valueOf(value));			
	}
	
	public void put(String key,float value) {
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
		
		GeneralDataListEntity list = new GeneralDataListEntity(value);
		
		this.set(key, list.toString());
		
	}
	
	public void set(String key,boolean value) {
		
		if(isRelease()) {
			return;
		}
		
		this.set(key, String.valueOf(value));
		
	}
	
	public void set(String key,float value) {
		
		if(isRelease()) {
			return;
		}
		
		this.set(key, String.valueOf(value));
		
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
		
		GeneralDataListEntity list=new GeneralDataListEntity(str);
		
		return list.toArrayList();
	}
	
	
	public Boolean getBoolean(String key) {
		
		if(isRelease()) {
			return false;
		}
		
		String str = this.get(key);
		
		return Boolean.valueOf(str);
	}
	
	public Float getFloat(String key) {
		
		if(isRelease()) {
			return -1F;
		}
		
		String str = this.get(key);
		
		return Float.valueOf(str);
	}
	
	public int getRepeat(String Match) {
		
		if(isRelease()) {
			return -1;
		}
		
		return process.getRepeat(data, Match);
		
	}
	
	public ArrayList<String> getLine(){
		
		if(isRelease()) {
			return null;
		}
		
		ArrayList<String> al=new ArrayList<String>();
		
		
		//循环取出data中的内容
		

		while(this.data.next()){
			
			al.add(this.data.get());
			
		}
		
		
		return al;
		
	}
	
	
	//直接获取所有行内容
	public ArrayList<String> getAll(){
		
		ArrayList<String> als=new ArrayList<String>();
		
		
		while(data.next()) {
			
			als.add(data.get());
			
		}
		
		
		return als;
		
	}

	@Override
	public void close() {
		
		if(isChange) {
			io.writeGDCEntity(dataSources, data);
		}	
		
		data = null;
		dataSources = null;
		
		this.isRelease=true;
		this.isChange=false;
		
		fromFactory.getListDataSession().add(this);
		
	}
	
	
	
}
