package com.ksptooi.gdc.BukkitService;


import org.bukkit.plugin.java.JavaPlugin;

import com.ksptooi.gdc.Main.DataCore;

public class BukkitSupport extends JavaPlugin{

	
	public void onEnable(){
		
		DataCore.LogManager.logInfo("通用数据核心 版本:"+DataCore.gdc_Version);
		
	}
	
	
	
}

