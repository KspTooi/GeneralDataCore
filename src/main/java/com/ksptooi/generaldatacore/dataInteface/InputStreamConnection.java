package com.ksptooi.generaldatacore.dataInteface;

import com.ksptooi.generaldatacore.entity.data.DataSet;

import java.io.*;
import java.util.ArrayList;

public class InputStreamConnection extends DataConnection{

    private String charset = "utf-8";

    //ISC构造器
    public InputStreamConnection(InputStream is) {
        super(is, null);
    }

    public InputStreamConnection(InputStream is,String charset) {
        super(is, null);
        this.charset = charset;
    }

    /**
     * 从[任意数据源]获取到DataSet实例
     */
    @Override
    public DataSet getDataSet() {
        DataSet set = new DataSet(this,this.getStringList());
        return set;
    }

    /**
     * 尝试将DataSet更新至[数据源]
     *
     * @param dataSet 数据集
     * @return 成功返回true
     */
    @Override
    public boolean setDataSet(DataSet dataSet) {
        return false;
    }

    /**
     * 直接从数据源获取字符串格式的数据
     */
    @Override
    public ArrayList<String> getStringList() {

        ArrayList<String> list = new ArrayList<String>();

        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(this.getInputStream(),charset));

            String str = "";

            while((str = br.readLine())!=null){
                list.add(str);
            }

            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }
}
