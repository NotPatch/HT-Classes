package pw.hysteria.classes.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.configuration.PlayerData;
import pw.hysteria.classes.framework.Class;
import pw.hysteria.classes.framework.Level;
import pw.hysteria.classes.framework.Profile;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private final Classes main;
    private final PlayerData playerData;
    public Map<UUID, Profile> profiles = new HashMap<>();
    public Map<UUID, Class> totalPlayers = new HashMap<>();

    public ProfileManager(Classes main) {
        this.main = main;
        playerData = main.getConfigManager().getPlayerData();
    }

    public Profile createProfile(Player p) {
        Level level = new Level(1, 0);
        Profile profile = new Profile(null, level);
        profiles.put(p.getUniqueId(), profile);
        return profile;
    }

    public Profile getProfile(UUID uuid) {
        return profiles.get(uuid);
    }

    public int getTotalPlayers(Class clazz){
        for (String key : playerData.getSection("")) {
            UUID uuid = UUID.fromString(key);
            if(playerData.getClass(uuid) == clazz){
                totalPlayers.put(uuid, clazz);
            }
        }
        return totalPlayers.size();
    }

    public void saveProfiles() {
        for (UUID uuid : profiles.keySet()) {
            Profile profile = profiles.get(uuid);
            if(profile.getClazz() != null){
                playerData.setClass(uuid, profile.getClazz());
                playerData.setLevel(uuid, profile.getLevel().getLevel());
                playerData.setXp(uuid, profile.getLevel().getXp());
                playerData.setDisplayName(uuid, Bukkit.getPlayer(uuid).getName());
            }
        }
    }

    public void loadProfiles() {
        for (String key : playerData.getSection("")) {
            UUID uuid = UUID.fromString(key);
            Class clazz = playerData.getClass(uuid);
            Level level = playerData.getLevel(uuid);
            Profile profile = new Profile(clazz, level);
            profiles.put(uuid, profile);
        }
    }

}


