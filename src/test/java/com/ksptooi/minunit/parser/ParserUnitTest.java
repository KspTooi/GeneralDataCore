package com.ksptooi.minunit.parser;

import org.junit.Test;

import com.ksptooi.generaldatacore.parser.KVParser;

public class ParserUnitTest {
	
	
	
	@Test
	public void ParserUnit() {
		
		String str = "player.ksptooi=5";
		
		String key = KVParser.key(str);
		
		String val = KVParser.value(str);
		
		System.out.println("key:"+key);
		
		System.out.println("value:" + val);
	}
	
	
	

}
