package com.ksptooi.minunit.fileio;

import java.math.BigInteger;
import java.nio.file.Paths;
import org.junit.Test;
import com.ksptooi.generaldatacore.DataCore;
import com.ksptooi.generaldatacore.entity.data.DataMap;

public class FileRWUnit {
	
	
	
//	@Test
	public void FileRWUnit() {

		
		
		
//		System.out.println(dm.get("key5")+dm.size());
		
	}
	
	
	@Test
	public void FileUnit() {
		
		
		 DataMap dm = DataCore.getDataMap("C:asmc_core/asmc.conf",true);
		  
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
