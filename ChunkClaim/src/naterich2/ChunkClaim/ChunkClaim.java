package naterich2.ChunkClaim;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class ChunkClaim extends JavaPlugin {
	@Override
	public void onEnable(){
		getCommand("claim").setExecutor(new Cmd_Executor(this));
		getCommand("aclaim").setExecutor(new Cmd_Executor(this));
		getCommand("strike").setExecutor(new Cmd_Executor(this));
		this.getLogger().info("ChunkClaim has been enabled!");
	}
	public void onDisable(){
		this.getLogger().info("ChunkClaim has been disabled!");
	}
	private bListener listener = new bListener(this);
	
	public void claim(Player p, Location loc){
		
	}
}
