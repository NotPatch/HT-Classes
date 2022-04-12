package pw.hysteria.classes;

import fr.minuskube.inv.InventoryManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pw.hysteria.classes.command.CMDTest;
import pw.hysteria.classes.listener.PlayerDamageListener;
import pw.hysteria.classes.listener.PlayerJoinListener;
import pw.hysteria.classes.listener.PlayerProjectileListener;
import pw.hysteria.classes.manager.ConfigManager;
import pw.hysteria.classes.manager.ProfileManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Classes extends JavaPlugin {

    public ProfileManager profileManager;
    public ConfigManager configManager;

    private static InventoryManager invManager;

    private static Classes instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configManager = new ConfigManager(this);
        configManager.loadConfigs();
        profileManager = new ProfileManager(this);
        profileManager.loadProfiles();
        invManager = new InventoryManager(this);
        invManager.init();

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerProjectileListener(), this);
        getCommand("class").setExecutor(new CMDTest());

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            new ClassExpansion().register();
        }

    }

    @Override
    public void onDisable() {
        profileManager.saveProfiles();
        configManager.saveConfigs();
    }

    public ProfileManager getProfileManager() {
        return profileManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public static InventoryManager getInvManager() {
        return invManager;
    }

    public static Classes getInstance() {
        return instance;
    }

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String color(String message){
        Matcher match = pattern.matcher(message);
        while ((match.find())){
            String colored = message.substring(match.start(), match.end());
            message = message.replace(colored, ChatColor.of(colored) + "");
            match = pattern.matcher(message);
        }
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
