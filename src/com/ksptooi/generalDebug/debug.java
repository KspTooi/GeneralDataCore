package com.ksptooi.generalDebug;

import java.io.File;

import com.ksptooi.gdc.v6.Factory.DataSessionFactory;
import com.ksptooi.gdc.v6.Session.dataSession;

import uk.iksp.gdc.v7.FactoryBuilder.GeneralDataFactoryBuilder;

public class debug {

	public static void main(String[] args){
		
		
		
		GeneralDataFactoryBuilder GDFB=new GeneralDataFactoryBuilder();		
		
		
		
		DataSessionFactory bdf = GDFB.buildDataFactory(16);
		
		
		Thread th=new Thread(new Runnable(){

			@Override
			public void run() {
				
				while(true){
					dataSession ds = bdf.openSession(new File("C://123.gd"));
					
					ds.release();
				}

				
			}
			
		});
		
		th.start();
		
		
		while(true){
			dataSession ds = bdf.openSession(new File("C://123.gd"));
			
			ds.release();
		}

		
		
	}

}
