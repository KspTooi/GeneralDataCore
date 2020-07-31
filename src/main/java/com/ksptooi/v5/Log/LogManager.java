package com.ksptooi.v5.Log;



public abstract class LogManager{

	
	String Prefix="Prefix_example";

	
	//发送一般信息
	public abstract void logInfo(String Message);
	
	//发送警告信息
	public abstract void logWarning(String Message);
	
	//发送错误信息
	public abstract void logError(String Message);
	
	
	
	public String getPrefix() {
		return Prefix;
	}

	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	
	
}
