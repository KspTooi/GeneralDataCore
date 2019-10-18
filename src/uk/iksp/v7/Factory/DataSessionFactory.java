package uk.iksp.v7.Factory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import uk.iksp.v7.Session.DataSession;
import uk.iksp.v7.Session.InputStreamReaderSession;

public class DataSessionFactory{
	
	
	private ConcurrentLinkedQueue<DataSession> listDataSession = new ConcurrentLinkedQueue<DataSession>();
	
	private int poolInitSize=32;
	
	
	//构造方法
	public DataSessionFactory(int size) {
		
		this.poolInitSize = size;

		for (int i = 0; i < this.poolInitSize; i++) {

			DataSession ds = new DataSession(this);

			listDataSession.add(ds);

		}

	}
	
	//打开一个输入流读取Session
	public synchronized InputStreamReaderSession openInputStreamReaderSession(){
		
		
		
		
		
		return null;
	}
	
	
	
	//打开一个数据Session
	public synchronized DataSession openSession(File file) {
		
		if(listDataSession.size() > 0) {
			
			DataSession DataSession = listDataSession.poll();
			
			DataSession.assign(this,file);
			
			return DataSession;
		}
		
		throw new RuntimeException("没有可分配的DataSession!");		
	}
	
	
	
	//创建文件
	public boolean createdata(File file) {
		
		if(file.exists()){
			return false;
		}
		
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		DataSession DataSession = this.openSession(file);
		
		DataSession.put("@Type", "GeneralDataCore");
		DataSession.put("@Version", "v7");
		DataSession.addline(" ");
		DataSession.release();
		
		return true;	
	}
	
	
	//getseter
	public ConcurrentLinkedQueue<DataSession> getListDataSession() {
		return listDataSession;
	}

	public void setListDataSession(ConcurrentLinkedQueue<DataSession> listDataSession) {
		this.listDataSession = listDataSession;
	}


	public void destoryFactory() {

		listDataSession = null;
		poolInitSize=0;
		
	}
	
	
}
