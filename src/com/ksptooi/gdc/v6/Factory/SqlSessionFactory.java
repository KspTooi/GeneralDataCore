package com.ksptooi.gdc.v6.Factory;

import java.util.LinkedList;
import com.ksptooi.gdc.v6.Session.SqlSession;

public class SqlSessionFactory{

	
	private String address="*";
	
	private String dbName="*";
	
	private String user="*";
	
	private String password="*";
	
	private String param="*";
	
	private int poolInitSize=16;
	
	private LinkedList<SqlSession> listConnections = new LinkedList<SqlSession>();
	
	
	//SSF构造方法
	public SqlSessionFactory(String address,String dbName,String user,String pwd,String param,int initSize) {
		
		//初始化属性
		this.address=address;
		this.dbName=dbName;
		this.user=user;
		this.password=pwd;
		this.param=param;	
		this.poolInitSize=initSize;
		
		//创建SQL连接
		for(int i=0;i<poolInitSize;i++) {
			
//			System.out.println("jdbc:mysql://"+address+"/"+dbName+param);
				
			SqlSession sqlSession = new SqlSession(this,"jdbc:mysql://"+address+"/"+dbName+param,user,password);
				
//			System.out.println("获取到SqlSession:"+sqlSession);
				
			listConnections.add(sqlSession);
				
		}		
		
	}
	
    public synchronized SqlSession getSqlSession(){
    	
    	
    	while(true) {
    		 		
            //如果数据库连接池中的连接对象的个数大于0
            if (listConnections.size() > 0) {
            	
                //从集合中获取一个数据库连接
                SqlSession sqlSession = listConnections.removeFirst();
                
//              System.out.println("当前数据库连接池大小是" + listConnections.size());
                 
                //检查连接有效性
                if(sqlSession.isClosed()) {
//                	System.out.println("待分配的SqlSession已失效");
                	continue;
                }	
                  
                //分配
                sqlSession.assign(this);
                               
                return sqlSession;
                
            }
            
            
            //如果数据库连接池中的连接对象等于或小于0
            throw new RuntimeException("当前数据库正忙!.");		
    		
    	}
    	
        
    }

    
	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public int getPoolInitSize() {
		return poolInitSize;
	}

	public void setPoolInitSize(int poolInitSize) {
		this.poolInitSize = poolInitSize;
	}

	public LinkedList<SqlSession> getListConnections() {
		return listConnections;
	}

	public void setListConnections(LinkedList<SqlSession> listConnections) {
		this.listConnections = listConnections;
	}
	
	
}
