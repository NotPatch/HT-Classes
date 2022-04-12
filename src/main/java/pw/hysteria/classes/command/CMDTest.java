package pw.hysteria.classes.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.gui.GUISelect;

public class CMDTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1){
            Player p = (Player) sender;
            GUISelect.INVENTORY.open(p);
        }else{
            Classes.getInstance().getConfigManager().getGuiData().loadConfiguration();
            Bukkit.dispatchCommand(sender, "su reloadplugin HTClasses");
        }

        return false;
    }

}
