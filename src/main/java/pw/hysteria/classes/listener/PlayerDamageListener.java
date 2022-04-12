package pw.hysteria.classes.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.framework.Class;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void skillGhiblon(EntityDamageByEntityEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        Class clazz = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId()).getClazz();
        if(clazz != Class.GHIBLON) return;
        int level = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId()).getLevel().getLevel();
        double math = ((level / 3) + ThreadLocalRandom.current().nextDouble(1.25, 5.30));
        double damage = (e.getDamage() * math) / 100;
        e.setDamage(e.getDamage() - damage);
		p.sendMessage(String.valueOf(math));
		p.sendMessage(String.valueOf(damage));
		p.sendMessage(String.valueOf(e.getDamage()));

    }

}
