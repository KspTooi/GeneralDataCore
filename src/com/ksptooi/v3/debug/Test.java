package com.ksptooi.v3.debug;

import java.io.File;
import java.util.ArrayList;

import com.ksptooi.v3.Entity.KeyList;

import uk.iksp.v7.Factory.DataSessionFactory;
import uk.iksp.v7.FactoryBuilder.GeneralDataFactoryBuilder;
import uk.iksp.v7.Session.DataSession;

public class Test {


	public static void main(String[] args){
		
		
		
//		System.out.println((true&&false));
		
		
		
		GeneralDataFactoryBuilder gdfb=new GeneralDataFactoryBuilder();
		
		DataSessionFactory dsf = gdfb.buildDataFactory(32);
		
		
		try(DataSession os = dsf.openSession(new File("C:/123.gd"))){
			
			
			
		}
		
		
		
		
		
//		GeneralDataFactoryBuilder GDFB=new GeneralDataFactoryBuilder();		
//		
//		
//		
//		DataSessionFactory bdf = GDFB.buildDataFactory(16);
//		
//		
//		Thread th=new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				
//				while(true){
//					DataSession ds = bdf.openSession(new File("C://123.gd"));
//					
//					ds.release();
//				}
//
//				
//			}
//			
//		});
//		
//		th.start();
//		
//		
//		while(true){
//			DataSession ds = bdf.openSession(new File("C://123.gd"));
//			
//			ds.release();
//		}

		
		
	}

}
