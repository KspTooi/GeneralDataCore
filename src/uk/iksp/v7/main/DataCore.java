package uk.iksp.v7.main;

import com.ksptooi.v5.Log.LogManager;
import com.ksptooi.v5.Log.gdcLog;

public class DataCore {

	
	public static void main(String[] args) {
		
		System.out.println("GeneralDataCore°æ±¾:"+DataCore.gdc_Version);
		
		System.out.println("GeneralDataCore - A");
		
	}
	
	
	public static final String gdc_Version="V7.21-A";
	
	public static LogManager LogManager=new gdcLog();
	
	public static String getVersion() {
		return gdc_Version;
	}
	
	
}
