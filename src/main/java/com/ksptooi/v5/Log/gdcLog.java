package com.ksptooi.v5.Log;

import uk.iksp.v7.main.DataCore_Leagacy;

public class gdcLog extends LogManager{

	
	//ππ‘Ï
	public gdcLog(){		
		this.setPrefix("[GeneralDataCore"+DataCore_Leagacy.gdc_Version+"]");		
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
