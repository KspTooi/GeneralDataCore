package uk.iksp.v7.service.gdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.ksptooi.v3.Entity.GeneralDataEntity;
import uk.iksp.v6.CharSet.Detector;
import uk.iksp.v7.main.DataCore;
import uk.iksp.v7.service.stream.StreamDataSourceIO;

public class GeneralDataSourceIO extends StreamDataSourceIO{

	
	Detector detector=null;
	
	
	
	public GeneralDataSourceIO(){
		this.detector=new Detector();
	}
	
	
	//从文件获取GDC实体
	public GeneralDataEntity getGeneralDataEntity(File File){

		//自动探测文件编码
		String encode = this.detector.detector(File);
				
		InputStream is = null;
		
		try {
			
			is = new FileInputStream(File);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		
		GeneralDataEntity gde = this.readAsGeneralDataEntity(is, encode);
		
		
		return gde;
	}
	
	
	
	
	
	//写GDC实体至文件
	public void updateGeneralDataEntity(File file,GeneralDataEntity entity){
		

		
		this.writeGeneralDataEntity(file, entity);
		
	}
	
	
	//覆盖写入至文件
	public void updateFile(File file,String str){
				
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		this.writeFile(fos, str);
			
	}
	
	
	
	
	//获取文件的指定行 通过 InputStream
	public String getFileKeyLineOfInputStream(InputStream is, String key, String separationSymbol) {
		
		
		try{
			
			BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
			String line=null;
			
			
			while((line=br.readLine()) != null){
				
				if(line.contains(key+separationSymbol)){
					br.close();
					return line;
				}
				
			}
			
			br.close();
			return null;
					
			
		}catch(Exception e){
			e.printStackTrace();
			DataCore.logManager.logError("文件系统错误 at getFileKey");
		}
		
		
		return null;
		
	}
	
	
	
}
