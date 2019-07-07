package com.ksptooi.gdc.v6.FileIO;

import com.ksptooi.gdc.Entity.GDCEntity;
import com.ksptooi.gdc.v6.FileProcess.dataSession;

public interface DataIO_v2 {

	
	//获取GDC实体
	public GDCEntity getGDCEntity(dataSession ds,GDCEntity gdce);
	
	//写GDC实体
	public void writeGDCEntity(dataSession ds,GDCEntity gdce);
	
	//覆盖写入
	public void writeFile(dataSession ds,GDCEntity gdce);
	
	//覆盖写入
	public void writeFile(dataSession ds,String string);
	
	
}
