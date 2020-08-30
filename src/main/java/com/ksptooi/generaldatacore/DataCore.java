package com.ksptooi.generaldatacore;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.ksptooi.generaldatacore.common.Project;
import com.ksptooi.generaldatacore.entity.data.DataSet;



public class DataCore{

	

	public static void main(String[] args) {
		System.out.println("GeneralDataCore - Version:"+Project.version);
	}
	
	protected DataCore(){}
	
	
	
	/**
	 * 获取数据对象
	 */
/*	public static DataSet getDataMap(Path path, boolean autoMatic) {
		
		FileDataInteface dataInterface = FileDataInteface.getFileDataInteface(path);
		
		if(dataInterface == null) {
			return null;
		}
		
		DataSet dm = dataInterface.getDataMap();
		
		dm.setAutomaticRead(autoMatic);
		dm.setAutomaticWrite(autoMatic);
		
		return dm;
		
	}*/
	
/*	public static DataSet getDataMap(Path path) {
		return getDataMap(path,false);
	}
	
	public static DataSet getDataMap(String filePath) {
		return getDataMap(Paths.get(filePath),false);		
	}
	
	public static DataSet getDataMap(File file) {
		return getDataMap(file.toPath(),false);
	}
	
	
	public static DataSet getDataMap(String filePath, boolean automatic) {
		return getDataMap(Paths.get(filePath),automatic);		
	}*/
	
/*	public static DataSet getDataMap(File file, boolean automatic) {
		return getDataMap(file.toPath(),automatic);
	}*/


	
	
	
	
	
	
	

}
