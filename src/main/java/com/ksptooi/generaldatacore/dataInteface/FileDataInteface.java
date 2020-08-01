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
public class FileDataInteface implements DataInterface{

	
	
	Path path = null;
	
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
	
	
	
	
	
	
	
	@Override
	public String getString(String key) {
		return null;
	}

	@Override
	public Integer getInt(String key) {
		return null;
	}

	@Override
	public Boolean getBoolean(String key) {
		return false;
	}

	@Override
	public Float getFloat(String key) {
		return null;
	}

	@Override
	public Double getDouble(String key) {
		return null;
	}

	@Override
	public ArrayList<String> getStringList(String key) {
		return null;
	}

	@Override
	public ArrayList<Integer> getIntegerList(String key) {

		return null;
	}

	@Override
	public ArrayList<Boolean> getBooleanList(String key) {

		return null;
	}

	@Override
	public ArrayList<Float> getFloatList(String key) {

		return null;
	}

	@Override
	public ArrayList<Double> getDoubleList(String key) {

		return null;
	}

	@Override
	public DataMap getDataMap() {
		return null;
	}

	
	
	
	
	
	
	
	
}
