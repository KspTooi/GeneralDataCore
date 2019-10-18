package com.ksptooi.v5.Log;

import uk.isp.v7.main.DataCore;

public class gdcLog extends LogManager{

	
	//ππ‘Ï
	public gdcLog(){
		
		this.setPrefix("[GeneralDataCore"+DataCore.gdc_Version+"]");
		
	}
	
	
	
	@Override
	public void logInfo(String Message) {	
		System.out.println(this.getPrefix()+Message);
	}

	
	@Override
	public void logWarning(String Message) {	
		System.out.println(this.getPrefix()+Message);
	}
	

	@Override
	public void logError(String Message) {	
		System.out.println(this.getPrefix()+Message);
	}

	
	
	
	
}
