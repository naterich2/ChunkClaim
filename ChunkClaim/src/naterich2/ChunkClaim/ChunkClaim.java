package naterich2.ChunkClaim;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class ChunkClaim extends JavaPlugin {
	
	HashMap<Chunk, String> claims = new HashMap<Chunk, String>();
	
	@Override
	public void onEnable(){
		getCommand("claim").setExecutor(new Cmd_Executor(this));
		getCommand("abandon").setExecutor(new Cmd_Executor(this));
		getCommand("strike").setExecutor(new Cmd_Executor(this));
		
		Bukkit.getServer().getPluginManager().registerEvents(new bListener(this), this);
		
		this.getLogger().info("ChunkClaim has been enabled!");
	}
	@Override
	public void onDisable(){
		this.getLogger().info("ChunkClaim has been disabled!");
	}
	
	public void claim(Chunk c, Player p){
		claims.put(c, p.getName());
	}
	public void abandon(Chunk c) throws NullPointerException {
		claims.remove(c);
	}	
	public String getOwner(Chunk c){
		return claims.get(c);
	}
	
}
