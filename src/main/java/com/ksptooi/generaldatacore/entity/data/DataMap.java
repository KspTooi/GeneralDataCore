package com.ksptooi.generaldatacore.entity.data;

import java.util.HashMap;

import com.ksptooi.generaldatacore.common.Type;

public class DataMap extends HashMap<String, String>{

	
	private static final long serialVersionUID = 1L;
	
	
	
	public String getString(String k) {
		return this.get(k);
	}
	
	public Integer getInt(String k) {
		return Type.toInt(k);
	}
	
	public Double getDouble(String k) {
		return Type.toDouble(k);
	}
	
	public Float getFloat(String k) {
		return Type.toFloat(k);
	}
	
	public Boolean getBoolean(String k) {
		return Type.toBoolean(k);
	}
	

}
