package com.ksptooi.udc.entity.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.ksptooi.udc.entity.node.Node;
import com.ksptooi.udc.io.UdcWriter;

public class UniversalData extends BasicData implements AutoCloseable{
	

	//实例化通用数据
	public UniversalData(List<String> content,Path path,Charset cs) {
		this.content = (ArrayList<String>) content;
		this.sourcePath = path;
		this.charset = cs;
	}
	
	public UniversalData(ArrayList<String> content,Path path,Charset cs) {
		this.content = content;
		this.sourcePath = path;
		this.charset = cs;
	}
	
	
	/**
	 * 获取根节点
	 * @return 返回UDNode实例
	 */
	public Node getRoot() {
		
		Node root = new Node("root", content);
		return root;
		
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
