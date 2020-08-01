package com.ksptooi.generaldatacore.test;

import org.junit.Test;

import com.ksptooi.generaldatacore.DataCore;
import com.ksptooi.generaldatacore.dataInteface.DataInterface;

public class GeneralDataCoreTest {
	
	
	@Test
	public void dataIntefaceTest() {
		
		
		DataInterface di = DataCore.getDataInteface("C:\\asmc_core/asmc.conf1");
		
		
		if(di == null) {
			System.out.println("获取数据接口失败");
			return;
		}
		
		
		System.out.println("获取数据接口成功");
		
	}
	
	
	

}
