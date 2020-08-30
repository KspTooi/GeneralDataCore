package com.ksptooi.generaldatacore.dataInteface;

import com.ksptooi.generaldatacore.entity.data.DataSet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileDataConnection extends DataConnection {


    public FileDataConnection(Path path) {
        super(path);
    }

    @Override
    public DataSet getDataMap() {
        /*ArrayList<String> allFileLine = (ArrayList<String>) Files.readAllLines(this.getPath());*/
        DataSet dm = new DataSet(this,this.getStringList());
        return dm;
    }

    @Override
    public boolean setDataMap(DataSet dataSet) {

        try {

            Files.write(this.getPath(), dataSet.string().getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    /**
     * 直接从数据源获取字符串格式的数据(path)
     */
    @Override
    public ArrayList<String> getStringList() {

        try {

            ArrayList<String> allStringList = (ArrayList<String>) Files.readAllLines(this.getPath(),StandardCharsets.UTF_8);
            return allStringList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
