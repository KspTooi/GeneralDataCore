package com.ksptooi.generaldatacore.test.dataconnect;

import com.ksptooi.generaldatacore.dataInteface.DataConnection;
import com.ksptooi.generaldatacore.dataInteface.FileDataConnection;
import com.ksptooi.generaldatacore.entity.data.DataSet;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class DataConnect_String {

    /**
     * 文件数据接口测试(字符串)
     */
    @Test
    public void FileDataConnectionUnit() throws IOException {

        File file = Paths.get("C://127.txt").toFile();

        if(!file.exists()){
            file.createNewFile();
        }

        DataConnection connection = new FileDataConnection(file.toPath());

        DataSet dataMap = connection.getDataSet().setAutomatic(true);

        dataMap.val("key1","helloworld");

        System.out.println(dataMap.val("key1"));
        System.out.println(dataMap.val("key2")==null);
        System.out.println(dataMap.val("key3"));

    }



}
