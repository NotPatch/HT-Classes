package pw.hysteria.classes.listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.framework.Class;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerProjectileListener implements Listener {

    @EventHandler
    public void onBow(ProjectileLaunchEvent e){
        if(!(e.getEntity().getShooter() instanceof Player)) return;
        if(!(e.getEntity() instanceof Arrow)) return;
        Player p = (Player) e.getEntity().getShooter();
        Class clazz = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId()).getClazz();
        int level = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId()).getLevel().getLevel();
        if(clazz != Class.JESTER) return;
        if(hasFlame(p)) return;
        int random = new Random().nextInt((100 - 1) + 1) + 1;
        if(random < (level / 5) * 0.5){
            ((Arrow) e.getEntity()).addCustomEffect(new PotionEffect(PotionEffectType.POISON, 20 + (20*(level / 100)) + ThreadLocalRandom.current().nextInt(1, 15), 1), true);
        }else if(random < (level / 5) * 1){
            ((Arrow) e.getEntity()).addCustomEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 + (20*(level / 100)) + ThreadLocalRandom.current().nextInt(1, 15), 1), true);
        }else if(random < (level / 5) * 1.5){
            ((Arrow) e.getEntity()).addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 + (20*(level / 100)) + ThreadLocalRandom.current().nextInt(1, 15), 1), true);
        }else if(random < (level / 5) * 2){
            ((Arrow) e.getEntity()).addCustomEffect(new PotionEffect(PotionEffectType.HARM, 20 + (20*(level / 100)) + ThreadLocalRandom.current().nextInt(1, 15), 1), true);
        }


    }

    public boolean hasFlame(Player p){
        return p.getInventory().getItemInMainHand().containsEnchantment(Enchantment.ARROW_FIRE);
    }

}
