package naterich2.ChunkClaim;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

public final class ChunkClaim extends JavaPlugin {
	
	HashMap<String, Chunk> owns = new HashMap<String, Chunk>();
	
	@Override
	public void onEnable(){
		getCommand("claim").setExecutor(new Cmd_Executor(this));
		getCommand("aclaim").setExecutor(new Cmd_Executor(this));
		getCommand("strike").setExecutor(new Cmd_Executor(this));
		this.getLogger().info("ChunkClaim has been enabled!");
	}
	@Override
	public void onDisable(){
		this.getLogger().info("ChunkClaim has been disabled!");
	}
	private bListener listener = new bListener(this);
	
	public void claim(Player p, Chunk c){
		owns.put(p.getName(), c);
	}
	public boolean isOwned(Player p, Chunk c){
		if((owns.get(p.getName()).getX() == c.getX()) && (owns.get(p.getName()).getZ() == c.getZ()) && (owns.get(p.getName()).getWorld().equals(c.getWorld())))
			return true;
		else
			return false;
	}
}
