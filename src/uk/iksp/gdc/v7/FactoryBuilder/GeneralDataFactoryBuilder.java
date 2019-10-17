package uk.iksp.gdc.v7.FactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ksptooi.gdc.Main.DataCore;
import com.ksptooi.gdc.v6.Factory.DataSessionFactory;
import com.ksptooi.gdc.v6.Session.dataSession;

import uk.iksp.gdc.v7.Xml.XmlUtil;

public class GeneralDataFactoryBuilder{

	
	
	SqlSessionFactoryBuilder ssfb=null;
	
	
	public GeneralDataFactoryBuilder(){
		ssfb = new SqlSessionFactoryBuilder();
	}
	
	
	
	//构建DataSessionFactory
	public DataSessionFactory buildDataFactory(int SessionPoolSize) {
		
		return new DataSessionFactory(SessionPoolSize);	
		
	}
	
	
	//构建SqlSessionFactory - 从文件构建
	public SqlSessionFactory buildSqlSessionFactory(File file){
		
		
		DataSessionFactory df = this.buildDataFactory(4);
		
		dataSession os = df.openSession(file);
		
		//获取参数
		String url = os.get("url");
		String userName = os.get("userName");
		String passWord = os.get("passWord");
		String poolMaximumActiveConnections = os.get("poolMaximumActiveConnections");
		
		XmlUtil.setXmlParameter(url, userName, passWord, poolMaximumActiveConnections);
		
		os.release();
		
		
		try {
			
			
			InputStreamReader isr=new InputStreamReader(new FileInputStream(new File("GeneralDataCore/GeneralDataCore-Config.xml")));
				
			SqlSessionFactory ssf = ssfb.build(isr);
			
			return ssf;
			
			
		} catch (FileNotFoundException e) {
			DataCore.LogManager.logError("构建SqlSession时错误! - 文件系统错误!");
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
}
