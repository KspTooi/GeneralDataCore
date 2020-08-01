package uk.iksp.v7.session.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import uk.iksp.v7.Xml.XmlUtil;
import uk.iksp.v7.main.DataCore_Leagacy;
import uk.iksp.v7.session.gdata.GDataSession;



public class GFactoryBuilder{

	
	
	SqlSessionFactoryBuilder ssfb=null;
	
	
	public GFactoryBuilder(){
		ssfb = new SqlSessionFactoryBuilder();
	}
	
	
	
	//构建DataSessionFactory
	public DataSessionFactory buildDataFactory(int SessionPoolSize) {
		
		return new DataSessionFactory(SessionPoolSize);	
		
	}
	
	
	//构建StreamFactory
	public StreamFactory buildStreamFactory(){
		return new StreamFactory();
	}
	
	//构建SqlSessionFactory - 使用外部资源文件构建
	public SqlSessionFactory buildSqlSessionFactory(File connectUrl,String resourceUrl){
		
		
		DataSessionFactory df = this.buildDataFactory(4);
		
		
		GDataSession os = df.openSession(connectUrl);
		
		//获取参数
		String url = os.get("url");
		String userName = os.get("userName");
		String passWord = os.get("passWord");
		String poolMaximumActiveConnections = os.get("poolMaximumActiveConnections");
		
		XmlUtil.setXmlParameter(resourceUrl,url, userName, passWord, poolMaximumActiveConnections);
		
		os.release();
		
		try {
			
			InputStreamReader isr=new InputStreamReader(new FileInputStream(new File(resourceUrl)));
				
			SqlSessionFactory ssf = ssfb.build(isr);
			
			return ssf;
			
			
		} catch (FileNotFoundException e) {
			DataCore_Leagacy.LogManager.logError("构建SqlSession时错误! - 文件系统错误!");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	//构建SqlSessionFactory - 从文件构建
	public SqlSessionFactory buildSqlSessionFactory(File file){
		
		
		DataSessionFactory df = this.buildDataFactory(4);
		
		GDataSession os = df.openSession(file);
		
		//获取参数
		String url = os.get("url");
		String userName = os.get("userName");
		String passWord = os.get("passWord");
		String poolMaximumActiveConnections = os.get("poolMaximumActiveConnections");
		
		XmlUtil.setXmlParameter(url, userName, passWord, poolMaximumActiveConnections);
		
		os.release();
		
		try {
			
			InputStreamReader isr=new InputStreamReader(new FileInputStream(new File("./GeneralDataCore/GeneralDataCore-Config.xml")));
				
			SqlSessionFactory ssf = ssfb.build(isr);
			
			return ssf;
			
			
		} catch (FileNotFoundException e) {
			DataCore_Leagacy.LogManager.logError("构建SqlSession时错误! - 文件系统错误!");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
}
