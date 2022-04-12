package pw.hysteria.classes.configuration;

import pw.hysteria.classes.Classes;
import pw.hysteria.classes.framework.Class;

import java.util.ArrayList;
import java.util.List;

public class GuiData extends Config{

    public GuiData(Classes main) {
        super(main, "gui.yml");
    }

    public static List<String> lore(String path){
        List<String> list = new ArrayList<>();
        List<String> colored = new ArrayList<>();
        list.addAll(Classes.getInstance().getConfigManager().getGuiData().getStringList("Gui." + path));

        for(String msg : list){
            msg = msg.replace("%totalplayers_ghiblon%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.GHIBLON)));
            msg = msg.replace("%totalplayers_avaria%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.AVARIA)));
            msg = msg.replace("%totalplayers_jester%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.JESTER)));
            msg = msg.replace("%totalplayers_york%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.YORK)));
            msg = msg.replace("%totalplayers_phobia%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.PHOBIA)));
            colored.add(Classes.color(msg));
        }
        return colored;
    }

}
