package pw.hysteria.classes;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import pw.hysteria.classes.framework.Profile;

public class ClassExpansion extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "classes";
    }

    @Override
    public @NotNull String getAuthor() {
        return "NotPatch";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    public boolean persist() {
        return true;
    }

    public boolean canRegister() {
        return true;
    }

    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("name"))
            return (player == null) ? null : player.getName();
        if (params.equalsIgnoreCase("class")) {
            Profile profile = Classes.getInstance().getProfileManager().getProfile(player.getUniqueId());
            return profile.getClazz().getName();
        }
        if (params.equalsIgnoreCase("tag")) {
            Profile profile = Classes.getInstance().getProfileManager().getProfile(player.getUniqueId());
            return profile.getClazz().getTag();
        }
        return null;
    }

}
