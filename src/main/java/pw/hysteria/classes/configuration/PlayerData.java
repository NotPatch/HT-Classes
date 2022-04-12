package pw.hysteria.classes.configuration;

import pw.hysteria.classes.Classes;
import pw.hysteria.classes.framework.Class;
import pw.hysteria.classes.framework.Level;

import java.util.UUID;

public class PlayerData extends Config{


    public PlayerData(Classes main) {
        super(main, "playerdata.yml");
    }

    public Class getClass(UUID uuid){
        return Class.getClassByName(getString(uuid.toString() + ".class"));
    }

    public void setClass(UUID uuid, Class clazz){
        set(uuid.toString() + ".class", clazz.getRawName());
    }

    public void setDisplayName(UUID uuid, String name) { set(uuid.toString() + ".name", name); }

    public Level getLevel(UUID uuid){
        return new Level(getBLevel(uuid) ,getXp(uuid));
    }

    public int getBLevel(UUID uuid) {
        return getInt(uuid.toString() + ".level");
    }

    public int getXp(UUID uuid) {
        return getInt(uuid.toString() + ".xp");
    }

    public void setLevel(UUID uuid, int level) {
        set(uuid.toString() + ".level", level);
    }

    public void setXp(UUID uuid, int xp){
        set(uuid.toString() + ".xp", xp);
    }

}
