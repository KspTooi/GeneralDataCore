package uk.iksp.v7.session.common;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import com.ksptooi.v3.Entity.GeneralDataEntity;
import com.ksptooi.v3.Entity.GeneralDataListEntity;
import com.ksptooi.v3.Entity.KeyList;

import uk.iksp.v7.service.gdata.GeneralDataSourceIO;
import uk.iksp.v7.session.factory.DataSessionFactory;

public abstract class AbstractGDataSession implements AutoCloseable{
	
	
	
	//数据缓存
	public GeneralDataEntity dataCache=null;
	
	//IO
	public GeneralDataSourceIO io= new GeneralDataSourceIO();
	
	
	//FromFactory
	protected DataSessionFactory fromFactory=null;
	
	
	//是否已被释放
	protected boolean isRelease=true;
	
	
	
	
	//分配
	public abstract void assign(DataSessionFactory df,File dataSources);
	
	
	//分配
	public void assign(DataSessionFactory df,InputStream dataSources){
		
	}
	
	//释放
	public abstract void release();
	
	
	//判断是否已分配
	protected boolean isRelease() {
		
		if(this.isRelease) {
			throw new RuntimeException("该Session已被释放.");	
		}
		
		return false;
	}
	
	
	
	
	
	/**
	 * 数据操作方法
	 */
	
	
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
