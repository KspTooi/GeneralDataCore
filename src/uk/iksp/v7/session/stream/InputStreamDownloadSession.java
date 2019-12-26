package uk.iksp.v7.session.stream;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import uk.iksp.v7.session.common.AbstractStreamSession;

public class InputStreamDownloadSession extends AbstractStreamSession{

	
	InputStream dataSources = null;
	
	
	
	public void assign(InputStream dataSources){
		
		this.isRelease = false;
		
		//加载数据源
		this.dataSources=dataSources;
		
	}
	
	
	
	public void downLoad(String path,String fileName){
		
		
		try{
			
	        //获取字节数组
	        byte[] getData = readInputStream(dataSources);

	        //文件保存位置
	        File saveDir = new File(path);
	        if(!saveDir.exists()){
	            saveDir.mkdir();
	        }
	        
	        File file = new File(saveDir+File.separator+fileName);
	        
	        FileOutputStream fos = new FileOutputStream(file);
	        
	        fos.write(getData);
	        
	        
	        if(fos!=null){
	            fos.close();
	        }
	        
	        if(dataSources!=null){
	        	
	        	dataSources.close();
	        	
	        }
	
			
		}catch(Exception e){
			e.printStackTrace();
		}  
		
		
	}
	
	
	
    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException{
    	
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        
        while((len = inputStream.read(buffer)) != -1) {
        	
            bos.write(buffer, 0, len);
            
        }
        
        
        
        bos.close();
        return bos.toByteArray();
        
    }
	
	
	
	
	
	
	
	
	
	
	@Override
	public void close(){
		
		
	}

	@Override
	public void release() {
		
		
	}

}
