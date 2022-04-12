package pw.hysteria.classes.manager;


import pw.hysteria.classes.Classes;
import pw.hysteria.classes.configuration.Config;
import pw.hysteria.classes.configuration.GuiData;
import pw.hysteria.classes.configuration.PlayerData;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private final Classes main;
    private final List<Config> configList = new ArrayList<>();
    private final PlayerData playerData;
    private final GuiData guiData;


    public ConfigManager(Classes main){
        this.main = main;
        configList.add(playerData = new PlayerData(main));
        configList.add(guiData = new GuiData(main));
    }

    public void loadConfigs(){
        for(Config config : configList){
            config.loadConfiguration();
        }
    }

    public void saveConfigs(){
        for(Config config : configList){
            config.saveConfiguration();
        }
    }

    public PlayerData getPlayerData(){
        return playerData;
    }

    public GuiData getGuiData() {
        return guiData;
    }
}
