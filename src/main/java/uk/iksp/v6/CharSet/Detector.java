package uk.iksp.v6.CharSet;

import java.io.File;
import java.nio.charset.Charset;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;


public class Detector {

	
	public String detector(File file){
		
		
		CodepageDetectorProxy cdp=CodepageDetectorProxy.getInstance();
		
		cdp.add(null);
		
		JChardetFacade.getInstance();
		
		//Ìí¼ÓÐáÌ½Æ÷
		cdp.add(JChardetFacade.getInstance());
		
		String encode = null;
		
		Charset charset = null;
		
		
		try {
			
			charset = cdp.detectCodepage(file.toURI().toURL());
			
			
		}catch (Exception e) {			
			encode = "UTF-8";
			return encode;
		}
		
		
		if(charset == null){
			encode = "UTF-8";
			return encode;
		}
		
		//Ì½²â³É¹¦
		encode = charset.name();
		
		
		return encode;
		
		
	}
	
	
}
