package uk.iksp.v7.session.stream;

import java.io.IOException;
import java.io.InputStream;
import uk.iksp.v7.session.common.AbstractStreamSession;


public class InputStreamReaderSession extends AbstractStreamSession{

	
	
	
	InputStream dataSources = null;
	
	
	
	
	//分配
	public void assign(InputStream dataSources){
		
		this.isRelease = false;
		
		//加载数据源
		this.dataSources=dataSources;
		
		//加载数据
		this.dataCache = io.readAsGeneralDataEntity(this.dataSources);
		
	}
	
	
	//关闭/释放 Session
	@Override
	public void close(){
			
		this.isRelease = true;
		dataCache = null;
		
		try {
			dataSources.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void release() {
		this.close();
	}

	
	
	
	
	
}
