package com.ksptooi.generaldatacore.dataInteface;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

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
		
		try {
			
			
			ArrayList<String> allLine = (ArrayList<String>) Files.readAllLines(path);
			
			
			DataMap dm = new DataMap(this,allLine);
			
			
			return dm;
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}


	/**
	 * 写结果集
	 */
	@Override
	public void setDataMap(DataMap dm) {
		
		
		try {
			
			
			Files.write(path, dm.string().getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public ArrayList<String> getList() {
		
		
		try {
			
			ArrayList<String> allLine = (ArrayList<String>) Files.readAllLines(path);
			return allLine;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	
	
}
