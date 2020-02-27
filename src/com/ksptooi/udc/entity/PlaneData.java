package com.ksptooi.udc.entity;

import com.ksptooi.udc.io.UdcWriter;

public class PlaneData extends BasicData{

	
	
	/**
	 * 将PlaneData[平面数据]转换为UniversalData[通用数据]
	 * @return 返回UniversalData实例
	 */
	public UniversalData toUniversalData() {
		
		BasicData basic = (BasicData)this;
		UniversalData universal = (UniversalData) basic;
		return universal;
	}
	
	
	/**
	 * 立即同步更新文件
	 */
	public void flush() {
		UdcWriter.writeUniversalDataNE(this.toUniversalData());
	}
	
	
}
