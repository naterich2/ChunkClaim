package naterich2.ChunkClaim;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class bListener implements Listener {
	
	private ChunkClaim plugin;
	
	public bListener(ChunkClaim instance){
		plugin = instance;
	}
	
	public void onBlockBreak(BlockBreakEvent evt){
		if(evt.getPlayer().hasPermission("ChunkCLaim.aclaim")){
			evt.getPlayer().sendMessage("This chunk is owned by a player, are you sure you want to break it?");
		}
		else if(!(evt.getPlayer().hasPermission("ChunkClaim.aclaim"))){
			evt.getBlock().setTypeId(evt.getBlock().getTypeId());
			evt.getPlayer().sendMessage(ChatColor.RED+"This chunk is owned by another player, you cant break it!");
		}
				
	}

}
