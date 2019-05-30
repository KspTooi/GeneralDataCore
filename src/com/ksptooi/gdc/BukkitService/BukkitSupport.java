package com.ksptooi.gdc.BukkitService;

import org.bukkit.plugin.java.JavaPlugin;
import com.ksptooi.gdc.Util.Var;

public class BukkitSupport extends JavaPlugin{

	
	public void onEnable(){
		
		Var.LogManager.writeLogOfINFO("通用数据核心 版本:"+Var.gdc_Version);
		
	}
	
	
	
}
