package com.ksptooi.udc.entity.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.ksptooi.udc.entity.node.RNode;
import com.ksptooi.udc.io.UdcWriter;

public class UniversalData extends BasicData implements AutoCloseable{
	

	private RNode root = null;
	
	//实例化通用数据
	public UniversalData(List<String> content,Path path,Charset cs) {
		this.content = (ArrayList<String>) content;
		this.sourcePath = path;
		this.charset = cs;
		root = new RNode("root", this.content);
		

		
	}
	
	public UniversalData(ArrayList<String> content,Path path,Charset cs) {
		
		this.content = content;
		this.sourcePath = path;
		this.charset = cs;
		root = new RNode("root", this.content);
		
	}
	
	
	/**
	 * 获取根节点
	 * @return 返回RootNode实例
	 */
	public RNode getRoot() {
		return this.root;
	}
	
	/**
	 * 将UniversalData[通用数据]转换为PlaneData[平面数据]
	 * @return 返回PlaneData[平面数据]实例
	 */
	public PlaneData toPlaneData() {
		
		BasicData bd = (BasicData)this;
		PlaneData pd = (PlaneData)bd;
		return pd;
	}
	
	/**
	 * 立即同步更新至文件
	 * @throws IOException 
	 */
	public void flush() {
		UdcWriter.writeUniversalDataNE(this);
	}

	
	@Override
	public void close() throws Exception {
		UdcWriter.writeUniversalData(this);
	}

	
}
