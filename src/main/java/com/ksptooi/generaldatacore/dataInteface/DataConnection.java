package com.ksptooi.generaldatacore.dataInteface;

import com.ksptooi.generaldatacore.entity.data.DataSet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * 抽象数据获取器
 */
public abstract class DataConnection {

    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private File file = null;
    private Path path = null;

    private boolean supportRead = true;
    private boolean supportWrite = true;



    public DataConnection(InputStream is, OutputStream os){
        this.inputStream =is;
        this.outputStream =os;
    }

    public DataConnection(File f){
        this.file=f;
    }

    public DataConnection(Path p){
        this.path=p;
    }

    /**
     * 从[任意数据源]获取到DataSet实例
     */
    public abstract DataSet getDataSet();


    /**
     * 尝试将DataSet更新至[数据源]
     * @param dataSet 数据集
     * @return 成功返回true
     */
    public abstract boolean setDataSet(DataSet dataSet);

    /**
     * 直接从数据源获取字符串格式的数据
     */
    public abstract ArrayList<String> getStringList();


    public InputStream getInputStream()  {


        if(this.inputStream == null){
            throw new RuntimeException("cant get -- inputStream is Null ");
        }

        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {

        if(this.outputStream == null){
            throw new RuntimeException("cant get -- outputStream is Null ");
        }

        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public File getFile() {

        if(this.file == null){
            throw new RuntimeException("cant get -- file is Null ");
        }

        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Path getPath() {

        if(this.path == null){
            throw new RuntimeException("cant get -- path is Null ");
        }

        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public boolean isSupportRead() {
        return supportRead;
    }

    public void setSupportRead(boolean supportRead) {
        this.supportRead = supportRead;
    }

    public boolean isSupportWrite() {
        return supportWrite;
    }

    public void setSupportWrite(boolean supportWrite) {
        this.supportWrite = supportWrite;
    }
}
