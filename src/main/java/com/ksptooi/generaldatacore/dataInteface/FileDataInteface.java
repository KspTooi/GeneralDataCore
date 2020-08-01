package com.ksptooi.generaldatacore.dataInteface;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.ksptooi.generaldatacore.entity.data.DataMap;


/**
 * 单例模式
 */
public class FileDataInteface implements DataInterface {

	
	Path path = null;
	
	DataMap dm = null;
	
	
	private FileDataInteface(Path path) {
		this.path = path;
	}
	
	
	
	public static FileDataInteface getFileDataInteface(String path) {
		
		
		Path p = Paths.get(path);
		
		
		if(Files.isDirectory(p)) {
			return null;
		}
		
		if( ! Files.exists(p)) {
			return null;
		}
		
		
		return new FileDataInteface(p);
		
	}
	
	
	
	
	public static FileDataInteface getFileDataInteface(File f) {
		
		Path p=f.toPath();
		
		if(Files.isDirectory(p)) {
			return null;
		}
		
		if( ! Files.exists(p)) {
			return null;
		}
		
		return new FileDataInteface(p);
	}
	
	
	public static FileDataInteface getFileDataInteface(Path p) {
		
		
		if(Files.isDirectory(p)) {
			return null;
		}
		
		if( ! Files.exists(p)) {
			return null;
		}
		
		
		return new FileDataInteface(p);
	}



	
	/**
	 * 取结果集
	 */
	@Override
	public DataMap getDataMap() {
		return null;
	}


	/**
	 * 写结果集
	 */
	@Override
	public void setDataMap(DataMap dm) {
		
	}

	
	
	
	
}
