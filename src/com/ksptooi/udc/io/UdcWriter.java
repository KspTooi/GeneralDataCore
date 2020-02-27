package com.ksptooi.udc.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

import com.ksptooi.udc.entity.UniversalData;

public class UdcWriter {

	
	public static void writeUniversalData(UniversalData ud) throws IOException {
		
		BufferedWriter nbw = Files.newBufferedWriter(ud.getPath(), ud.getCharset());
		
		
		for(String str:ud.getContent()) {
			
			nbw.write(str);
			nbw.newLine();
		}
		
		nbw.flush();
		nbw.close();
		
	}
	
	
	
}
