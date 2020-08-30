package com.ksptooi.minunit.fileio;

import com.ksptooi.generaldatacore.dataInteface.DataConnection;
import com.ksptooi.generaldatacore.dataInteface.FileDataConnection;
import org.junit.Test;
import com.ksptooi.generaldatacore.entity.data.DataSet;

public class FileRWUnit {
	
	
	
//	@Test
	public void FileRWUnit() {


		//new BufferedReader(new InputStreamReader(null));

		DataConnection dc = new FileDataConnection(null);

		DataSet dataMap = dc.getDataSet();

		dataMap.val("");

//		System.out.println(dm.get("key5")+dm.size());




	}
	
	
	@Test
	public void FileUnit() {
		
		
/*		 DataSet dm = DataCore.getDataMap("C:asmc_core/asmc.conf",true);*/
		 DataSet dm = null;
		  
		 if(dm == null) {
			 System.out.println("文件不存在");
			 return;
		 }
		 
		  
		 String val = dm.getVal("key5");
		 
		 dm.setVal("key5", "555");
		 
		 dm.setVal("key8", false);
		  
		 System.out.println(dm.getBoolean("key8"));
		
	}
	
	

}
