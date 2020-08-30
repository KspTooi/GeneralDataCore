package com.ksptooi.generaldatacore.test.dataconnect;

import com.ksptooi.generaldatacore.dataInteface.DataConnection;
import com.ksptooi.generaldatacore.dataInteface.InputStreamConnection;
import com.ksptooi.generaldatacore.entity.data.DataSet;
import org.junit.Before;
import org.junit.Test;
import uk.iksp.v6.CharSet.Detector;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputStreamConnect_Unit {

    DataConnection connection = null;

    @Before
    public void Before() throws IOException {

        //创建测试文件
        File file = Paths.get("C://127.txt").toFile();

        if(!file.exists()){
            file.createNewFile();
        }

        //打开数据接口
        connection = new InputStreamConnection(Files.newInputStream(file.toPath()), Detector.detector(file));
    }

    @Test
    public void Test() throws IOException {

/*        DataSet dataMap = connection.getDataSet().setAutomatic(true);

        System.out.println(dataMap.toString());*/


        File file = Paths.get("C://127.txt").toFile();
        InputStream is = Files.newInputStream(file.toPath());


        BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));


        String line = null;

        System.out.println("第一次读:"+is.available());
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        BufferedReader br1 = new BufferedReader(new InputStreamReader(is,"utf-8"));

        System.out.println("第二次读:"+is.available());
        while((line=br1.readLine()) != null){
            System.out.println(line);
        }

    }



}
