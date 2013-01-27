package naterich2.ChunkClaim;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
public class Cmd_Executor implements CommandExecutor {
	private ChunkClaim plugin;
	public Cmd_Executor(ChunkClaim p){
		plugin = p;
	}
	public boolean onCommand(CommandSender s, Command cmd, String label, String [] args){
		if(s instanceof Player){
			Player player = (Player) s;
			
			if(cmd.getName().equalsIgnoreCase("claim")){
				if(player.hasPermission("ChunkClaim.claim")){
					if(args.length > 0)
						s.sendMessage("Usage: /claim");
					Chunk c =  player.getLocation().getChunk();
					if(plugin.getOwner(c) != null){
						s.sendMessage(ChatColor.RED+"This block has arleady been claimed");
					} else {
						plugin.claim(c, player);
						s.sendMessage(ChatColor.BLUE+"You have claimed the chunk at X: "+c.getX()+"  and Z: "+c.getZ());
					}
					return true;
				}
				else
					s.sendMessage("You dont have permission to do this");
			}
			else if(cmd.getName().equalsIgnoreCase("abandon")){
				if(player.hasPermission("ChunkClaim.abandon")){
					if(args.length > 0)
						s.sendMessage("Usage: /claim");
					Chunk c  = player.getLocation().getChunk();
					if(plugin.getOwner(c) != null){
						if(plugin.getOwner(c).equalsIgnoreCase(player.getName())){
							plugin.abandon(c);
							s.sendMessage(ChatColor.BLUE+ "You have abandoned the chunk at X: "+c.getX()+"  and Z: "+c.getZ());
						}
						else
							s.sendMessage(ChatColor.RED+"You do not own this block!");
					} else
						s.sendMessage(ChatColor.RED+"The block at X: "+c.getX()+"  and Z: "+c.getZ()+"  Has not been claimed yet");
					return true;
				} else
					s.sendMessage("You dont have permission to do this");
			}
			else if(cmd.getName().equalsIgnoreCase("strike")){
				if(args.length == 0){
					player.getWorld().strikeLightning(player.getLocation());
					return true;
				}
				else if((args.length == 1)){
					Player target =  Bukkit.getServer().getPlayer(args[0]);
					if(target == null)
						s.sendMessage(args[0]+ "Is not online");
					else{
						target.getWorld().strikeLightning(target.getLocation());
						return true;
					}
				}
				else {
					s.sendMessage("Too many arguments");
					return false;
				}
			}
		}
		else{
			s.sendMessage("You must be a player to use this command");
			return false;
		}
		return false;
	}

}
