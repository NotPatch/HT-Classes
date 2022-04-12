package pw.hysteria.classes.configuration;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import pw.hysteria.classes.Classes;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public abstract class Config extends YamlConfiguration {

    protected Classes main;
    protected String name;
    protected File file;

    public Config(Classes main, String name){
        this.name = name;
        this.main = main;
        file = new File(main.getDataFolder(), name);
    }

    public Set<String> getSection(String path){
        ConfigurationSection configurationSection = getConfigurationSection(path);
        if(configurationSection != null) return configurationSection.getKeys(false);
        return new HashSet<>();
    }



    private void checkConfig(){
        if(!file.exists()){
            file.getParentFile().mkdirs();
            main.saveResource(name, false);
        }
    }

    public void loadConfiguration(){
        checkConfig();
        try {
            load(file);
            main.getLogger().info("Classes | Configuration " + "'" + name + "'" + " loaded successful!");
        }catch (InvalidConfigurationException | IOException exception){
            main.getLogger().severe("Classes | Configuration " + "'" + name + "'" + " can't loaded successful!");
            exception.printStackTrace();
        }
    }

    public void saveConfiguration(){
        checkConfig();
        try{
            save(file);
            main.getLogger().info("Classes | Configuration " + "'" + name + "'" + " saved successful!");
        }catch (IOException exception){
            main.getLogger().severe("Classes | Configuration " + "'" + name + "'" + " can't saved successful!");
            exception.printStackTrace();
        }
    }

}