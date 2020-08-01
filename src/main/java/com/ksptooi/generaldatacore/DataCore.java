package com.ksptooi.generaldatacore;

import java.io.File;
import java.nio.file.Path;

import com.ksptooi.generaldatacore.common.Storage;
import com.ksptooi.generaldatacore.dataInteface.DataInterface;
import com.ksptooi.generaldatacore.dataInteface.FileDataInteface;

/**
 * 单例模式 GDC
 */
public class DataCore{


	public static void main(String[] args) {
		System.out.println("GeneralDataCore - Version:"+Storage.version);
	}
	
	protected DataCore(){}
	
	

	
	/**
	 * 获取数据接口
	 */
	public static DataInterface getDataInteface(String filePath){
		return FileDataInteface.getFileDataInteface(filePath);
	}
	
	public static DataInterface getDataInteface(File file){
		return FileDataInteface.getFileDataInteface(file);
	}
	
	public  static DataInterface getDataInteface(Path path){
		return FileDataInteface.getFileDataInteface(path);
	}
	
	
	

}
