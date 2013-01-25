package naterich2.ChunkClaim;
import org.bukkit.command.*;
public class Cmd_Executor implements CommandExecutor {
	private ChunkClaim plugin;
	public Cmd_Executor(ChunkClaim p){
		plugin = p;
	}
	public boolean onCommand(CommandSender s, Command cmd, String label, String [] args){
		return false
	}

}
