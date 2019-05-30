package com.ksptooi.gdc.Log;

import com.ksptooi.gdc.Util.Var;

public class LogManager {

	//发送一般信息
	public void writeLogOfINFO(String Message){
		System.out.println("[GeneralDataCore"+Var.gdc_Version+"]·"+Message);
	}
	
	//发送警告信息
	public void writeLogOfWarning(String Message){
		System.out.println("[GeneralDataCore"+Var.gdc_Version+"]警告:"+Message);
	}
	
	//发送错误信息
	public void writeLogOfError(String Message){
		System.out.println("[GeneralDataCore"+Var.gdc_Version+"]错误:"+Message);
	}
	
	
}
