package pw.hysteria.classes.util;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.framework.Class;
import pw.hysteria.classes.framework.Profile;

public class ClassesUtil {

    public static void setClass(Player p, Class clazz){
        Profile profile = Classes.getInstance().getProfileManager().getProfile(p.getUniqueId());
        profile.setClazz(clazz);
        
        p.sendMessage(getMessage(clazz, "selection-message"));
        if(clazz == Class.GHIBLON){
            p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.085);
        }else if(clazz == Class.JESTER){
            p.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.125);
        }
    }

    private static String getMessage(Class clazz, String message){
        String msg = Classes.getInstance().getConfig().getString("Classes." + clazz.getRawName().toUpperCase() + "." + message);
        if(msg != null){
            msg = Classes.color(msg);
            return msg;
        }
        return null;
    }


}
