package com.ksptooi.udc.entity.node;

import java.util.ArrayList;

import com.ksptooi.udc.parser.NodeParser;
import com.ksptooi.udc.parser.Parser;

public class Node {

	
	private String name = null;
	
	//����ĸ�������
	private ArrayList<String> content = null;
	
	//����Ľڵ�
	private ArrayList<Node> nodeList = null;
	
	
	public Node(String name,ArrayList<String> content) {
		
		this.name = name;
		
		this.content = content;
		
		//�����ӽڵ�
		String data = "";
		
		for(String s:content) {
			data = data + s;
		}
		
		nodeList = NodeParser.parserNodeList(data);
		
		//�����ı�
		this.content = NodeParser.clearNodeData(this.content);
		
	}
	
	
	/**
	 * ��ȡָ����key������λ��
	 * @param key
	 * @return ����λ��,û���ҵ�keyʱ����-1
	 */
	public int getIndex(String key) {
		
		String currentKey = null;
		
		
		for(int i=0;i<content.size();i++) {
			
			//�������ָ�����ֱ������
			if( ! content.get(i).contains("=")) {
				continue;
			}
			
			currentKey = Parser.toKey(content.get(i));
			
			if(currentKey.equals(key)){
				return i;
			}
			
		}
		
		return -1;
	}
	
	
	/**
	 * ��ȡָ��key��value
	 * @param key
	 * @return
	 */
	public String get(String key) {
		
		int index = this.getIndex(key);
		
		if(index == -1) {
			return null;
		}
		
		return Parser.toValue(content.get(index));
		
	}
	
	/**
	 * ��ȡָ��int���͵�value
	 * @param key
	 * @return 
	 * ��keyδ�ҵ�ʱ����-1
	 * ��key�Ѵ��ڵ��޷�ת��Ϊintʱ����-2
	 */
	public int getInt(String key) {
		
		String result = this.get(key);
		
		if(result == null) {
			return -1;
		}
		
		try {
			return Integer.valueOf(result);
		}catch(Exception e) {
			return -2;
		}
		
	}
	
	/**
	 * ��ȡָ��Double���͵�value
	 * @param key
	 * @return 
	 * ��keyδ�ҵ�ʱ����-1
	 * ��key�Ѵ��ڵ��޷�ת��ΪDoubleʱ����-2
	 */
	public double getDouble(String key) {
		
		String result = this.get(key);
		
		if(result == null) {
			return -1;
		}
		
		try {
			return Double.valueOf(result);
		}catch(Exception e) {
			return -2;
		}
		
	}
	
	/**
	 * ��ȡָ��Boolean���͵�value
	 * @param key
	 * @return 
	 * ��keyδ�ҵ�ʱ����false
	 * ��key�Ѵ��ڵ��޷�ת��ΪBooleanʱ����false
	 */
	public boolean getBoolean(String key) {
		
		String result = this.get(key);
		
		if(result == null) {
			return false;
		}
		
		try {
			return Boolean.valueOf(result);
		}catch(Exception e) {
			return false;
		}
		
	}
	
	/**
	 * ����ָ��key��value
	 * @param key
	 * @param value
	 */
	public void set(String key,String value) {
		
		String newLine = key +"="+ value;
		
		int index = this.getIndex(key);
		
		if(index == -1) {
			return;
		}
		
		content.set(index, newLine);
		
	}
	
	
	
	public String getName() {
		return name;
	}


	public ArrayList<String> getContent() {
		return content;
	}


	public ArrayList<Node> getNodeList() {
		return nodeList;
	}
	
	
}