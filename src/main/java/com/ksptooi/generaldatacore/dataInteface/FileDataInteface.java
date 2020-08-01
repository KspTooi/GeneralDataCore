package com.ksptooi.generaldatacore.dataInteface;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.ksptooi.generaldatacore.entity.data.DataMap;


/**
 * µ¥ÀýÄ£Ê½
 */
public class FileDataInteface extends DataMap implements DataInterface {

	
	private static final long serialVersionUID = 1L;
	

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

	
	
	
	
}
