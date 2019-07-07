package com.ksptooi.generalDebug;

import java.io.File;
import java.util.ArrayList;

import com.ksptooi.gdc.Main.gdcList;
import com.ksptooi.gdc.v6.Manager.DataManager;

public class debug {

	public static void main(String[] args){
		
		
//		FileDAL_Input FDI=new FileDAL_Input();
//		FileDAL_OutPut FDO=new FileDAL_OutPut();
//		FileControllerBLL FCB=new FileControllerBLL();
//		
//		IOController_V5 V5=new IOController_V5();
//		File F=new File("F:/123.gd");
//		
//		V5.createNewGdcFile(F);
//		
//		V5.setTarget(F);
//		
//		V5.addLine("key1=5");
//		
//		System.out.println(V5.getKeyValue("@LineType"));
		
		
		ArrayList<String> al=new ArrayList<String>();
		
		al.add("KspTooi");
		al.add("RspTooi");
		al.add("TspTooi");
		al.add("Tpooi");
		al.add("pooi");
		
		
		File file = new File("C:/123.gd");
		
		DataManager v6 = new DataManager();
		
		v6.createGdc(file);
		
		v6.setTarget(file);
		
		al=v6.getListFromKey("PlayerList");
		
		al.remove(al.size()-1);
		
		v6.setKey("PlayerList", al);
		
		System.out.println();
		
		
		
	}

}
