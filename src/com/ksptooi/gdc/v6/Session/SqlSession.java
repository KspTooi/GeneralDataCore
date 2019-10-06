package com.ksptooi.gdc.v6.Session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import com.ksptooi.gdc.Main.DataCore;
import com.ksptooi.gdc.v6.Factory.SqlSessionFactory;

public class SqlSession {

	private SqlSessionFactory fromFactory = null;
	
	private boolean isRelease=true;

	private Connection conn=null;
	
	private Statement stm=null;
	
	private ResultSet rs=null;
	
	private PreparedStatement pStm=null;
	
	
	//SqlSessin 构造方法
	public SqlSession(SqlSessionFactory SSF,String url,String user,String pwd) {
		
		//加载SSF
		this.fromFactory = SSF;
		
		
		//判断SSF是否为空
		if(fromFactory == null) {
			throw new RuntimeException("SqlSessionFactory is empty");
		}
		
		//判断SSF是否为really
		if(!(fromFactory instanceof SqlSessionFactory)) {
			throw new RuntimeException("SqlSessionFactory is not Really");
		}
		
		
		//与 建立连接
		try {
			
			conn = DriverManager.getConnection(url, user, pwd);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("数据库错误:连接失败!");
			System.exit(0);
		}
		
	}
	
	
	//进行查询
	public ResultSet query(String sql) {
		
		if(isRelease) {
			throw new RuntimeException("该SqlSession已被释放!");
		}
		
		try {
			
			this.stm=conn.createStatement();
			
			this.rs=stm.executeQuery(sql);
			
			return this.rs;
						
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	
	}
	
	//进行非查询
	public int noQuery(String sql) {
		
		if(isRelease) {
			throw new RuntimeException("该SqlSession已被释放!");
		}
		
		try {
			
			this.stm=conn.createStatement();
			
			return stm.executeUpdate(sql);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	
	//判断某张表是否存在
	public boolean isExistsTable(String tableName){
		
		if(isRelease) {
			throw new RuntimeException("该SqlSession已被释放!");
		}
		
		try {
			
			ResultSet rs=conn.getMetaData().getTables(null, null, tableName, null);
			
	         if (rs.next()) {  
	               return true;  
	         }else {  
	               return false;  
	         } 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("数据库连接错误！");
		}
		
		
		return false;
	
	}
	
	
	
	//判断当前的SqlSession是否仍然有效
	public boolean isClosed() {
		try {
			return conn.isClosed();
		} catch (SQLException e) {
			return true;
		}
	}
	
	//分配
	public synchronized void assign(SqlSessionFactory ssf){
		
		if(fromFactory != ssf) {
			throw new RuntimeException("SqlSession分配时出现错误!");
		}
		
		if(!this.isRelease) {
			throw new RuntimeException("该SqlSession已被分配!");
		}
		
		this.isRelease=false;
	}
	
	
	//立即释放当前连接到连接池
	public synchronized void release() {
		
		if(isRelease) {
			throw new RuntimeException("该SqlSession已被释放!");
		}
		
		
		//关闭RS
		if(rs != null) {
			
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//关闭STM
		if(stm != null) {
			
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//关闭PSTM
		if(pStm != null) {
			
			try {
				pStm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//将SqlSession转交给Factory
		fromFactory.getListConnections().add(this);
		
//        System.out.println(this + "被还给listConnections数据库连接池了！！");
//        System.out.println("listConnections数据库连接池大小为" + fromFactory.getListConnections().size());
        
        this.isRelease=true;
		
	}
	
	
	//psmt相关的操作
	public void psmt_Create(String str) {
		
		try {
			
			this.pStm = this.conn.prepareStatement(str);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet psmt_Query() {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			return this.pStm.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void psmt_NoQuery() {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void psmt_setString(int i,String str2) {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.setString(i, str2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void psmt_setInt(int i,int i1) {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.setInt(i, i1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void psmt_setByte(int i,Byte b1) {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.setByte(i, b1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void psmt_setBytes(int i,byte[] b1) {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.setBytes(i, b1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void psmt_setBoolean(int i,boolean b1) {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.setBoolean(i, b1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void psmt_setTime(int i,Time b1) {
		
		if(this.pStm == null) {
			throw new RuntimeException("PreparaStatement没有创建!");
		}
		
		try {
			
			this.pStm.setTime(i, b1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
