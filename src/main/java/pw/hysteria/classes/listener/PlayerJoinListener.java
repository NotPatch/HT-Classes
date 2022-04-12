package pw.hysteria.classes.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.framework.Profile;
import pw.hysteria.classes.gui.GUISelect;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Profile profile = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId());
        if (profile == null) {
            profile = Classes.getInstance().getProfileManager().createProfile(p);
        }

        if(profile.getClazz() == null){
            GUISelect.INVENTORY.open(p);
            new BukkitRunnable(){
                @Override
                public void run() {
                    Profile profile = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId());
                    if(profile.getClazz() == null){
                        GUISelect.INVENTORY.open(p);
                    }
                }
            }.runTaskLater(Classes.getInstance(), 20*30);
        }
    }

}
