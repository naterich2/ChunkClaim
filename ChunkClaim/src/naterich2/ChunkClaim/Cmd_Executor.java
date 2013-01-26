package naterich2.ChunkClaim;

import org.bukkit.Bukkit;
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
				if(args.length > 0)
					s.sendMessage("Usage: /claim");

				Location loc =  player.getLocation();
				plugin.claim(player,loc);
				s.sendMessage("You have claimed this block");
				return true;
			}
			else if(cmd.getName().equalsIgnoreCase("aclaim")){
				if(player.hasPermission("ChunkClaim.aclaim")){
					if(args.length > 0)
						s.sendMessage("Usage: /claim");
					Location loc  = player.getLocation();
					plugin.claim(player, loc);
					s.sendMessage("You have claimed this block as an admin");
					return true;
				}
				else{
					s.sendMessage("You dont have permission to do this");
				}
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
