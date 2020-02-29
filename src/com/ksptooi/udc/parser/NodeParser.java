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
	 * 找到下一个节点块
	 * @return 返回一个包含节点块位置信息的数组
	 */
	public static int[] findNextNode(String str) {
		
		
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
							
				nodeContentStart = str.indexOf("{",nodeNameStart);
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
						nodeList.add(NodeParser.toNode(str.substring(nodeNameStart,nodeEnd+1)));
						break;
					}
					
				}
				
				break;
				
			}
			
		}
		
		int[] out = {nodeNameStart,nodeEnd};
		
		return out;
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
	 * 过滤包含节点的文本
	 */
	public static ArrayList<String> clearNodeData(ArrayList<String> input) {
		
		boolean hasNode = false;
		
		for(int i=0;i<input.size();i++) {
			
			if(input.get(i).contains("--")) {
				hasNode = true;
			}
			
			if(hasNode) {
				input.remove(i);
				i--;
			}
			
		}
		
		
		return input;
	}
	
	/**
	 * 过滤包含节点块的文本[并生成节点位置标识符]
	 */
	public static ArrayList<String> clearNodeBlock(String str) {
		

		String nodeBlock = null;
		
		int[] nodeLocation = null;
		
		while(true) {
			
			nodeLocation = NodeParser.findNextNode(str);
			
			//判断有无节点块Start标识符
			if(nodeLocation[0] != -1) {
				
				//截取节点文本
				nodeBlock = str.substring(nodeLocation[0],nodeLocation[1]+1);
				
				//替换中间文本
				str = str.replace(nodeBlock, "{{"+toNode(nodeBlock).getName()+"}}");
				
				continue;
			}
			
			break;
			
		}
		
		//处理元数据=>集合打包
		String[] split = str.split(",");
		
		ArrayList<String> op = new ArrayList<String>();
		
		for(String s:split) {
			op.add(s);
		}
		
		return op;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		String str = "\r\n" + 
				"key1=5\r\n" + 
				"key2=10\r\n" + 
				"\r\n" + 
				"--node1=>{\r\n" + 
				"\r\n" + 
				"	\"n1k1\"=25,\r\n" + 
				"	\"n1k2\"=35,\r\n" + 
				"	\r\n" + 
				"	--node1_1=>{\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"	\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"--node2=>{\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"key3=15";
		
		
		ArrayList<String> clearNodeBlock = clearNodeBlock(str);
		
		for(String s:clearNodeBlock) {
			System.out.println(s);
		}
		
		
	}
	
}
