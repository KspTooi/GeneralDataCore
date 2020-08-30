package com.ksptooi.generaldatacore.test.dataconnect;

import com.ksptooi.generaldatacore.dataInteface.DataConnection;
import com.ksptooi.generaldatacore.dataInteface.InputStreamConnection;
import com.ksptooi.generaldatacore.entity.data.DataSet;
import org.junit.Before;
import org.junit.Test;
import uk.iksp.v6.CharSet.Detector;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataConnect_ReadUnit {

    DataConnection connection = null;

    @Before
    public void Before() throws IOException {

        //创建测试文件
        File file = Paths.get("C://ASMC_Plugin.gd").toFile();

        if(!file.exists()){
            file.createNewFile();
        }

        //打开数据接口
        connection = new InputStreamConnection(Files.newInputStream(file.toPath()), Detector.detector(file));
    }


    @Test
    public void Test(){

        DataSet dataSet = connection.getDataSet().setAutomatic(false);

        System.out.println(dataSet.val("Plugin_Name"));
        System.out.println(dataSet.val("Plugin_Name"));


    }


}
