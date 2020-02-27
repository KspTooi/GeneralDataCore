package com.ksptooi.udc.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import com.ksptooi.udc.entity.data.UniversalData;

public class UdcWriter {

	/**
	 * 写入UniversalData实例至文件
	 * @param UniversalData实例
	 * @throws IOException 当写入失败时抛出异常.
	 */
	public static void writeUniversalData(UniversalData ud) throws IOException {
		
		BufferedWriter nbw = Files.newBufferedWriter(ud.getSourcePath(), ud.getCharset());
		
		
		for(String str:ud.getContent()) {
			
			nbw.write(str);
			nbw.newLine();
		}
		
		nbw.flush();
		nbw.close();
		
	}
	
	//写入UniversalData实例至文件
	public static void writeUniversalDataNE(UniversalData ud){
		
		try {
			writeUniversalData(ud);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
