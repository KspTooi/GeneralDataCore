package com.ksptooi.gdc.Log;

import com.ksptooi.gdc.Main.DataCore;

public class LogManager {

	//发送一般信息
	public void sendInfo(String Message){
		System.out.println("[GeneralDataCore"+DataCore.gdc_Version+"]·"+Message);
	}
	
	//发送警告信息
	public void sendWarning(String Message){
		System.out.println("[GeneralDataCore"+DataCore.gdc_Version+"]警告:"+Message);
	}
	
	//发送错误信息
	public void sendError(String Message){
		System.out.println("[GeneralDataCore"+DataCore.gdc_Version+"]错误:"+Message);
	}
	
	
	
}
