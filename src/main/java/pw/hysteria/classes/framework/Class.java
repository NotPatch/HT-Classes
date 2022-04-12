package pw.hysteria.classes.framework;

import org.bukkit.ChatColor;

public enum Class {

    GHIBLON("Ghiblon", "G"),
    AVARIA("Avaria", "A"),
    JESTER("Jester", "J"),
    YORK("York", "Y"),
    PHOBIA("Phobia", "P");

    private final String name;
    private final String rawName;
    private final String tag;

    Class(String name, String tag){
        this.name = name;
        this.tag = tag;
        rawName = ChatColor.stripColor(name);
    }

    public static Class getClassByName(String name){
        for(Class clazz : values()){
            if(name.equalsIgnoreCase(clazz.getRawName())){
                return clazz;
            }
        }
        return null;
    }

    public String getTag() {
        return tag;
    }

    public String getName() {
        return name;
    }

    public String getRawName() {
        return rawName;
    }

}
