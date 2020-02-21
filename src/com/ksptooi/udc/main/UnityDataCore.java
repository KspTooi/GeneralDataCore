package com.ksptooi.udc.main;

import java.io.IOException;

import com.ksptooi.udc.entity.UnityData;
import com.ksptooi.udc.io.UdcRead;

public class UnityDataCore {

	
	public static void main(String[] args) throws IOException {
		
		System.out.println("UnityDataCore°æ±¾:"+UnityDataCore.version);
		
		System.out.println("UnityDataCore - Pre");
		
//		System.out.println(Parser.toValue("key1=A555SA=SAS"));
		
		UnityData udf = UdcRead.readAsUnityData("C://asmc_core/asmc.conf");
		
//		for(String str:udf.getContent()) {
//			System.out.println(str);
//		}
		System.out.println(udf.get("key5"));
		udf.set("key5", "lolo");
		udf.flush();
		
	}
	
	public final static String version = "7.23-P";
	
}
