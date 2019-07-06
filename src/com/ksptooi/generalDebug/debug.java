package com.ksptooi.generalDebug;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ksptooi.gdc.Entity.GDCEntity;
import com.ksptooi.gdc.FileDAL.GeneralFileIO;
import com.ksptooi.gdc.v5.MysqlAPI.MysqlController;
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
		
		
		MysqlController MC=new MysqlController();
		
		File file = new File("C:/123.gd");
		
		DataManager V6 = new DataManager();
		
		V6.createGdc(file);
		
		V6.setTarget(file);
		
		V6.remove("通用数据核心");
		
		System.out.println(V6.getKeyForInt("a1"));
		
		
		
	}

}
