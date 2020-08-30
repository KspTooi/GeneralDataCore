package com.ksptooi.minunit.parser;

import com.ksptooi.generaldatacore.parser.KVParser;
import org.junit.Test;

import java.util.ArrayList;

public class ParserTest_List {

    @Test
    public void listToString(){

        ArrayList<String> list = new ArrayList<String>();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        list.add("测试4");

        //list转换为字符串
        String convert = KVParser.listToString(list);

        System.out.println("转换后的字符串为:"+convert);

        //字符串转为list
        ArrayList<String> convert1 = KVParser.stringToList(convert);
        System.out.println("转换后的list为:"+convert1.toString());

    }




}
