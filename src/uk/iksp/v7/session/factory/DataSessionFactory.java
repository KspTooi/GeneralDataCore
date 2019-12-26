package uk.iksp.v7.session.factory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

import uk.iksp.v7.session.gdata.GDataSession;

public class DataSessionFactory{
	
	
	private ConcurrentLinkedQueue<GDataSession> listDataSession = new ConcurrentLinkedQueue<GDataSession>();
	
	private int poolInitSize=32;
	
	
	//构造方法
	public DataSessionFactory(int size) {
		
		this.poolInitSize = size;

		for (int i = 0; i < this.poolInitSize; i++) {

			GDataSession ds = new GDataSession(this);

			listDataSession.add(ds);

		}

	}
	

	
	
	
	//打开一个数据Session
	public synchronized GDataSession openSession(File file) {
		
		if(listDataSession.size() > 0) {
			
			GDataSession GDataSession = listDataSession.poll();
			
			GDataSession.assign(this,file);
			
			return GDataSession;
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
			
		GDataSession GDataSession = this.openSession(file);
		
		GDataSession.put("@Type", "GeneralDataCore");
		GDataSession.put("@Version", "v7");
		GDataSession.addline(" ");
		GDataSession.release();
		
		return true;	
	}
	
	
	//getseter
	public ConcurrentLinkedQueue<GDataSession> getListDataSession() {
		return listDataSession;
	}

	public void setListDataSession(ConcurrentLinkedQueue<GDataSession> listDataSession) {
		this.listDataSession = listDataSession;
	}


	public void destoryFactory() {

		listDataSession = null;
		poolInitSize=0;
		
	}
	
	
}
