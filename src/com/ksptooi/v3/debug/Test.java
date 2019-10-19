package com.ksptooi.v3.debug;

import java.net.HttpURLConnection;
import java.net.URL;

import uk.iksp.v7.Factory.StreamFactory;
import uk.iksp.v7.FactoryBuilder.GeneralDataFactoryBuilder;
import uk.iksp.v7.Session.InputStreamDownloadSession;

public class Test {


	public static void main(String[] args){
		
		GeneralDataFactoryBuilder gdfb=new GeneralDataFactoryBuilder();
		
		StreamFactory sf=gdfb.buildStreamFactory();
		
		try {
			
			
			URL url = new URL("http://update.iksp.uk:81/GeneralDataCoreV7.05K.jar");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
			
			InputStreamDownloadSession isds = sf.openInputStreamDownloadSession(conn.getInputStream());

			
			isds.downLoad("C://", "15.jar");
			
			
			
        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		
		
//		System.out.println((true&&false));
		
		
		
//		GeneralDataFactoryBuilder gdfb=new GeneralDataFactoryBuilder();
//		
//		DataSessionFactory dsf = gdfb.buildDataFactory(32);
//		
//		
//		try(DataSession os = dsf.openSession(new File("C:/123.gd"))){
//			
//			
//			os.put("123", 4556);
//			
//			
//		}
		
		
		
		
		
		
		
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
