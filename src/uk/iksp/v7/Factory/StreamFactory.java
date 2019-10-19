package uk.iksp.v7.Factory;

import java.io.InputStream;

import uk.iksp.v7.Session.InputStreamDownloadSession;
import uk.iksp.v7.Session.InputStreamReaderSession;

public class StreamFactory {

	
	//打开一个输入流读取Session
	public synchronized InputStreamReaderSession openInputStreamReaderSession(InputStream is){
		

		InputStreamReaderSession isrs=new InputStreamReaderSession();
		
		isrs.assign(is);
			
		return isrs;
	}
	

	//打开一个输入流下载Session
	public synchronized InputStreamDownloadSession openInputStreamDownloadSession(InputStream is){
		
		
		InputStreamDownloadSession isds=new InputStreamDownloadSession();
		
		isds.assign(is);
			
		return isds;
	}
	
	
}
