package com.ksptooi.generaldatacore.dataInteface;

import java.io.File;
import java.nio.file.Path;

import com.ksptooi.generaldatacore.common.Storage;

/**
 * 单例模式 GDC
 */
public abstract class DataCore{

	
	
	private String filePath = null;
	private File file = null;
	private Path path = null;
	
	
	public static void main(String[] args) {	
		System.out.println("GeneralDataCore - Version:"+Storage.version);
	}
	
	
	protected DataCore(String path){	
		this.filePath = path;
	}
	
	protected DataCore(File file){
		this.file = file;
	}
	
	protected DataCore(Path path){
		this.path = path;
	}
	
	
	//**取数据接口
	

	
	
	/**
	 * getter setter
	 */

	public String getFilePath() {
		return filePath;
	}


	public File getFile() {
		return file;
	}


	public Path getPath() {
		return path;
	}


	
	
	
	
	
	
	
}
