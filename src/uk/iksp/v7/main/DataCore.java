package uk.iksp.v7.main;

import com.ksptooi.v5.Log.LogManager;
import com.ksptooi.v5.Log.gdcLog;

public class DataCore {

	
	public static void main(String[] args) {
		
		System.out.println("GeneralDataCore°æ±¾:"+DataCore.version);
		System.out.println("GeneralDataCore - Pre");
		
	}
	
	public static final String version="V7.23-P";
	
	public static LogManager logManager=new gdcLog();
	
	public static String getVersion() {
		return version;
	}
	
	
}
