package com.ksptooi.udc.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.ksptooi.udc.entity.UniversalData;

import uk.iksp.v6.CharSet.Detector;

public class UdcReader {

	private static Detector detector=new Detector();
	

	/**
	 * 将文件读作可操作的UniversalData实例 [不抛出异常]
	 * @param filePath 文件路径
	 * @return UnityData实例
	 */
	public static UniversalData read(String filePath) {
		
		UniversalData udf = null;
		
		try {
			udf = readAsUniversalData(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return udf;
	}
	
	
	/**
	 * 将文件读作可操作的UniversalData实例
	 * @param filePath 文件路径
	 * @return UnityData实例
	 * @throws IOException 文件读取出错时抛出异常
	 */
	public static UniversalData readAsUniversalData(String filePath) throws IOException {
	
		Path path = Paths.get(filePath);
		
		Charset encode = detector.nDetector(path.toFile());
		
		UniversalData udf = new UniversalData((ArrayList<String>)Files.readAllLines(path, encode),path,encode);
	
		return udf;
	}
	
	/**
	 * 将文件读作可操作的UniversalData实例 [不抛出异常]
	 * @param filePath 文件路径
	 * @return UnityData实例
	 */
	public static UniversalData readAsUniversalDataNE(String filePath) {
		
		UniversalData udf = null;
		
		try {
			udf = readAsUniversalData(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return udf;
	}
	
}
