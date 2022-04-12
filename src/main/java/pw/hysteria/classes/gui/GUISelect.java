package pw.hysteria.classes.gui;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import pw.hysteria.classes.Classes;
import pw.hysteria.classes.configuration.GuiData;
import pw.hysteria.classes.framework.Class;
import pw.hysteria.classes.util.ClassesUtil;
import pw.hysteria.classes.util.Item;

public class GUISelect implements InventoryProvider {

    public ItemStack info;

    public ItemStack ghiblon;
    public ItemStack avaria;
    public ItemStack jester;
    public ItemStack york;
    public ItemStack phobia;

    public ItemStack grayGlass;
    public ItemStack blackGlass;

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("class")
            .provider(new GUISelect())
            .size(6, 9)
            .title(string("Title"))
            .build();

    public GUISelect(){
        ghiblon = new Item(Material.valueOf(string("Ghiblon.Material"))).setDisplayName(string("Ghiblon.Name")).setLore(GuiData.lore("Ghiblon.Lore")).setGlow(Boolean.valueOf(string("Ghiblon.Glow"))).build();
        avaria = new Item(Material.valueOf(string("Avaria.Material"))).setDisplayName(string("Avaria.Name")).setLore(GuiData.lore("Avaria.Lore")).setGlow(Boolean.valueOf(string("Avaria.Glow"))).build();
        jester = new Item(Material.valueOf(string("Jester.Material"))).setDisplayName(string("Jester.Name")).setLore(GuiData.lore("Jester.Lore")).setGlow(Boolean.valueOf(string("Jester.Glow"))).build();
        york = new Item(Material.valueOf(string("York.Material"))).setDisplayName(string("York.Name")).setLore(GuiData.lore("York.Lore")).setGlow(Boolean.valueOf(string("York.Glow"))).build();
        phobia = new Item(Material.valueOf(string("Phobia.Material"))).setDisplayName(string("Phobia.Name")).setLore(GuiData.lore("Phobia.Lore")).setGlow(Boolean.valueOf(string("Phobia.Glow"))).build();
        info = new Item(Material.valueOf(string("Info.Material"))).setDisplayName(string("Info.Name")).addItemFlag(ItemFlag.HIDE_ATTRIBUTES).setLore(GuiData.lore("Info.Lore")).setGlow(Boolean.valueOf(string("Info.Glow"))).build();


        grayGlass = new Item(Material.GRAY_STAINED_GLASS_PANE).setDisplayName("").build();
        blackGlass = new Item(Material.BLACK_STAINED_GLASS_PANE).setDisplayName("").build();
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        setItems(contents);
        contents.set(2, 3, ClickableItem.of(ghiblon,
            e -> {
                player.closeInventory();
                ClassesUtil.setClass(player, Class.GHIBLON);
            } ));

        contents.set(3, 3, ClickableItem.of(avaria,
                e -> {
                    player.closeInventory();
                    ClassesUtil.setClass(player, Class.AVARIA);
                } ));

        contents.set(3, 5, ClickableItem.of(jester,
                e -> {
                    player.closeInventory();
                    ClassesUtil.setClass(player, Class.JESTER);
                } ));

        contents.set(3, 4, ClickableItem.of(york,
                e -> {
                    player.closeInventory();
                    ClassesUtil.setClass(player, Class.YORK);
                } ));

        contents.set(2, 5, ClickableItem.of(phobia,
                e -> {
                    if(e.getClick().isRightClick()){

                    }
                    ClassesUtil.setClass(player, Class.PHOBIA);
                } ));

    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    public void setItems(InventoryContents contents){
        contents.set(0, 4, ClickableItem.empty(info));
        contents.set(0,0, ClickableItem.empty(grayGlass));
        contents.set(0,1, ClickableItem.empty(grayGlass));
        contents.set(2,4, ClickableItem.empty(grayGlass));
        contents.set(0,2, ClickableItem.empty(blackGlass));
        contents.set(0,3, ClickableItem.empty(blackGlass));
        contents.set(0,5, ClickableItem.empty(blackGlass));
        contents.set(0,6, ClickableItem.empty(blackGlass));
        contents.set(0,7, ClickableItem.empty(grayGlass));
        contents.set(0,8, ClickableItem.empty(grayGlass));
        //
        contents.set(1,0, ClickableItem.empty(grayGlass));
        contents.set(1,1, ClickableItem.empty(blackGlass));
        contents.set(1,2, ClickableItem.empty(blackGlass));
        contents.set(1,3, ClickableItem.empty(blackGlass));
        contents.set(1,4, ClickableItem.empty(grayGlass));
        contents.set(1,5, ClickableItem.empty(blackGlass));
        contents.set(1,6, ClickableItem.empty(blackGlass));
        contents.set(1,7, ClickableItem.empty(blackGlass));
        contents.set(1,8, ClickableItem.empty(grayGlass));
        //
        contents.set(2,0, ClickableItem.empty(blackGlass));
        contents.set(2,1, ClickableItem.empty(blackGlass));
        contents.set(2,2, ClickableItem.empty(blackGlass));
        contents.set(2,6, ClickableItem.empty(blackGlass));
        contents.set(2,7, ClickableItem.empty(blackGlass));
        contents.set(2,8, ClickableItem.empty(blackGlass));
        //
        contents.set(3,0, ClickableItem.empty(blackGlass));
        contents.set(3,1, ClickableItem.empty(blackGlass));
        contents.set(3,2, ClickableItem.empty(blackGlass));
        contents.set(3,6, ClickableItem.empty(blackGlass));
        contents.set(3,7, ClickableItem.empty(blackGlass));
        contents.set(3,8, ClickableItem.empty(blackGlass));
        //
        contents.set(4,0, ClickableItem.empty(grayGlass));
        contents.set(4,1, ClickableItem.empty(blackGlass));
        contents.set(4,2, ClickableItem.empty(blackGlass));
        contents.set(4,3, ClickableItem.empty(blackGlass));
        contents.set(4,4, ClickableItem.empty(grayGlass));
        contents.set(4,5, ClickableItem.empty(blackGlass));
        contents.set(4,6, ClickableItem.empty(blackGlass));
        contents.set(4,7, ClickableItem.empty(blackGlass));
        contents.set(4,8, ClickableItem.empty(grayGlass));
        //
        contents.set(5,0, ClickableItem.empty(grayGlass));
        contents.set(5,1, ClickableItem.empty(grayGlass));
        contents.set(5,2, ClickableItem.empty(blackGlass));
        contents.set(5,3, ClickableItem.empty(blackGlass));
        contents.set(5,4, ClickableItem.empty(blackGlass));
        contents.set(5,5, ClickableItem.empty(blackGlass));
        contents.set(5,6, ClickableItem.empty(blackGlass));
        contents.set(5,7, ClickableItem.empty(grayGlass));
        contents.set(5,8, ClickableItem.empty(grayGlass));
    }

    public static String string(String message){
        String msg = Classes.getInstance().getConfigManager().getGuiData().getString("Gui." + message);
        if(msg != null){
            msg = Classes.color(msg);
            msg = msg.replace("%totalplayers_ghiblon%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.GHIBLON)));
            msg = msg.replace("%totalplayers_avaria%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.AVARIA)));
            msg = msg.replace("%totalplayers_jester%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.JESTER)));
            msg = msg.replace("%totalplayers_york%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.YORK)));
            msg = msg.replace("%totalplayers_phobia%", String.valueOf(Classes.getInstance().getProfileManager().getTotalPlayers(Class.PHOBIA)));
            return msg;
        }
        return null;
    }

}
