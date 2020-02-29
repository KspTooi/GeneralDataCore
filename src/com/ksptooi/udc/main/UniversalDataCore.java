package com.ksptooi.udc.main;

import java.io.IOException;
import java.util.ArrayList;

import com.ksptooi.udc.entity.data.UniversalData;
import com.ksptooi.udc.entity.node.Node;
import com.ksptooi.udc.entity.node.RNode;
import com.ksptooi.udc.io.UdcReader;

public class UniversalDataCore {

	
	public static void main(String[] args) throws IOException {
		
		System.out.println("UniversalDataCore - "+UniversalDataCore.version);
		
		System.out.println("UniversalDataCore - Pre");
		
		
		UniversalData udf = UdcReader.readAsUniversalData("C://test.gd");
		
		
		
		RNode root = udf.getRoot();
		

		ArrayList<Node> nodeList = root.getNodeList();
		
		
		
		
		
//		for(String str:root.getContent()) {
//			System.out.println(str);
//		}

		
//		System.out.println(nodeList.get(0).get("n1k1"));
//		
//		for(String str:nodeList.get(0).getContent()) {
//			System.out.println(str);
//		}
		
		
//		
//		for(Node node:nodeList) {
//			System.out.println(node.getName());
//		}
		
		
		
	}
	
	public final static String version = "8.0-P(28)";
	
}
