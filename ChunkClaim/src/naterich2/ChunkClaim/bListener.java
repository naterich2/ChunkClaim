package naterich2.ChunkClaim;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class bListener implements Listener {
	
	private ChunkClaim plugin;
	
	public bListener(ChunkClaim instance){
		plugin = instance;
	}
	@EventHandler
	public void onBlockBreak(BlockBreakEvent evt){
		if(plugin.getOwner(evt.getBlock().getChunk()).equalsIgnoreCase(evt.getPlayer().getName()) || plugin.getOwner(evt.getBlock().getChunk()) == null){
			return;
		} else {
			evt.setCancelled(true);
			evt.getPlayer().sendMessage(ChatColor.RED+"This chunk is owned by another player, you cant break it!");
		}
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent evt){
		if(plugin.getOwner(evt.getBlock().getChunk()).equalsIgnoreCase(evt.getPlayer().getName()) || plugin.getOwner(evt.getBlock().getChunk()) == null){
			return;
		} else {
			evt.setCancelled(true);
			evt.getPlayer().sendMessage(ChatColor.RED+"This chunk is owned by another player, you cant place a block here!");
		}
	}

}
