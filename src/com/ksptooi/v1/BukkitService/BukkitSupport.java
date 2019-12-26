package com.ksptooi.v1.BukkitService;


import org.bukkit.plugin.java.JavaPlugin;

import uk.iksp.v7.main.DataCore;

public class BukkitSupport extends JavaPlugin{

	
	public void onEnable(){
		
		DataCore.LogManager.logInfo("通用数据核心 版本:"+DataCore.gdc_Version);
		
	}
	
	
	
}

