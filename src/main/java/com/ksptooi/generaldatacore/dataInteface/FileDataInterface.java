package com.ksptooi.generaldatacore.dataInteface;

import java.util.ArrayList;
import com.ksptooi.generaldatacore.entity.data.DataMap;

public interface FileDataInterface {

	/**
	 * 文件数据接口
	 */
	
	
	/**
	 * 通过指定的key获取平面文件中的Value
	 * @param key
	 * @return 返回value 如果没有则返回空
	 */
	public String getString(String key);
	
	public Integer getnt(String key);
	
	public boolean getBoolean(String key);
	
	public Float getFloat(String key);
	
	public Double getDouble(String key);
	
	
	
	/**
	 * 通过指定的key获取平面文件中的集合
	 * @param key
	 * @return
	 */
	public ArrayList<String> getStringList(String key);
	
	public ArrayList<Integer> getIntegerList(String key);
	
	public ArrayList<Boolean> getBooleanList(String key);
	
	public ArrayList<Float> getFloatList(String key);
	
	public ArrayList<Double> getDoubleList(String key);
	
	
	/**
	 * 将平面文件读为map
	 */
	public DataMap getDataMap();
	
}
