package com.ksptooi.udc.parser;

import java.util.ArrayList;

import com.ksptooi.udc.entity.node.Node;

public class NodeParser {

	/**
	 * 将字符串解析为Node
	 * @param str 字符串
	 * @return node
	 */
	public static Node toNode(String str) {
		
		int start = str.indexOf("=>{");	
		int end = str.lastIndexOf("}");
		
		String nodeContent = str.substring(start+3, end);
		String nodeName = str.substring(2,start);	
		
		Node node=new Node(nodeName, parseNodeContent(nodeContent));
		return node;
	}
	
	/**
	 * 将字符串解析为NodeContent
	 * @return 包含NodeContent的List
	 */
	public static ArrayList<String> parseNodeContent(String str){
		
		String[] split = str.split(",");
		
		ArrayList<String> ret = new ArrayList<String>();
		
		for(String s:split) {
			ret.add(s);
		}
		
		return ret;
	}
	
	
	
	/**
	 * 从字符串中解析出NodeList
	 * @return 包含Node的集合
	 */
	public static ArrayList<Node> parserNodeList(String str) {
		
//		System.out.println("总长:"+str.length());
		
		int nodeNameStart = 0;
		int nodeContentStart = 0;
		int nodeEnd = 0;
		int openedMark = 0;
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		
		
		//找节点名称标识符
		for(int i=0;i<str.length();i++) {
			
			nodeNameStart=str.indexOf("--",i);
			
			
			//节点名称标识符
			if(nodeNameStart!=-1) {
				
//				System.out.println("节点Name标识符:"+nodeNameStart);
					
				nodeContentStart = str.indexOf("{",nodeNameStart);
//				System.out.println("节点Content标识符:"+nodeContentStart);
				openedMark++;
				
				//找节点结束符
				for(int u=nodeContentStart+1;u<=str.length();u++) {
					
					if(str.charAt(u)=='{') {
						openedMark++;
					}
					
					if(str.charAt(u)=='}') {
						openedMark--;
					}
					
					if(openedMark<1){
//						
						i=u;
						nodeEnd=u;
//						System.out.println(str.substring(nodeNameStart,nodeEnd+1));
//						System.out.println("结束于:"+u);
						nodeList.add(NodeParser.toNode(str.substring(nodeNameStart,nodeEnd+1)));
						break;
					}
					
				}
				
				
			}
			
			
			
		}
		
		
		
		return nodeList;
	}
	
	
	
	/**
	 * 从字符串中解析出NodeList
	 * @return 包含Node的集合
	 */
//	public static ArrayList<Node> parserNodeList(String str) {
//		
//		System.out.println("总长:"+str.length());
//		
//		int nodeStart = 0;
//		int nodeEnd = 0;
//		
//		int subNodeStart = 0;
//		
//		int subNodeFlagCount = 0;
//		
//		//找节点名称标识符
//		for(int i=0;i<str.length();i++) {
//			
//			nodeStart=str.indexOf("--",i);
//			
//			
//			//节点名称标识符
//			if(nodeStart!=-1) {
//				
//				System.out.println("节点名标:"+nodeStart);
//				
//				i = nodeStart;
//				
//				//找节点结束符
//				for(int u=nodeStart;u<=str.length();) {
//					
//					subNodeStart = str.indexOf("--",u+2);
//						
//					//判断记录子节点
//					if(subNodeStart!=-1) {
//						
//						System.out.println("子节点位置:"+subNodeStart);
//						u = subNodeStart+2;
//						subNodeFlagCount++;
//						
//					}
//					
//					nodeEnd = str.indexOf("}",u);
//					
//					//判断记录结束符
//					if(nodeEnd!=-1) {
//						
//						if(subNodeFlagCount>0) {
//							u=nodeEnd+1;
//							subNodeFlagCount--;
//							continue;
//						}
//						i =nodeEnd+1;
//						System.out.println("节点结束符:"+nodeEnd);
//						break;
//					}
//					
//				}
//				
//				
//			}
//			
//			
//			
//		}
//		
//		
//		
//		
//		return null;
//	}
	
	
	public static void main(String[] args) {
		
//		Node node = toNode("GFDGFG");
//		
//		System.out.println(node.getName());
//		
//		for(String s:node.getContent()) {
//			System.out.println(s);
//		}
		
		ArrayList<Node> parserNodeList = parserNodeList("key1=5\r\n" + 
				"key2=10\r\n" + 
				"\r\n" + 
				"--node=>{\r\n" + 
				"\r\n" + 
				"--node1_1=>{--node1_1=>{}},\r\n" + 
				"--node1_2=>{},\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"--node2=>{\r\n" + 
				"\r\n" + 
				"--node2_1=>{},\r\n" + 
				"--node2_2=>{},\r\n" + 
				"\r\n" + 
				"}");
		
		
		
		System.out.println(parserNodeList.get(0).getName());
		System.out.println(parserNodeList.get(0).getContent().get(2));
		
	}
	
}
