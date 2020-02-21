package uk.iksp.v6.CharSet;

import java.io.File;
import java.nio.charset.Charset;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;


public class Detector {

	
	public Charset nDetector(File file) {
		
		CodepageDetectorProxy cdp=CodepageDetectorProxy.getInstance();
		
		//Ìí¼ÓÐáÌ½Æ÷
		cdp.add(JChardetFacade.getInstance());
			
		Charset charset = Charset.forName("utf-8");
		
		
		try {
			
			charset = cdp.detectCodepage(file.toURI().toURL());
			
		}catch (Exception e) {			
			return Charset.forName("utf-8");
		}
		
		
		if(charset == null){
			return Charset.forName("utf-8");
		}
		
		//Ì½²â³É¹¦		
		return charset;
		
	}
	
	
	
	public String detector(File file){
		
		
		CodepageDetectorProxy cdp=CodepageDetectorProxy.getInstance();
		
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
