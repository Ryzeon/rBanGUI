package me.ryzeon.bangui.manager;

import lombok.Getter;
import lombok.Setter;
import me.ryzeon.bangui.rBanGUI;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.ItemCreator;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryzeon
 * Project: rBanGUI
 * Date: 15/10/2020 @ 08:58
 */
@Getter
@Setter
public class BanMenuManager {

    private List<Ban> banList = new ArrayList<>();
    private List<Mute> muteList = new ArrayList<>();
    private List<Warn> warnList = new ArrayList<>();
    private List<BanMenuItems> banMenuItems = new ArrayList<>();

    public void register(){

        rBanGUI.getInstance().getLogger().info("[Ban-Gui] Register Ban Menu Items");
        try {
            for (String bansListConfig : rBanGUI.getInstance().getMainMenuConfig().getConfig().getConfigurationSection("items").getKeys(false)){
                ItemCreator icon = new ItemCreator(
                        Material.valueOf(rBanGUI.getInstance().getMainMenuConfig().getConfig().getString("items." + bansListConfig + ".item.material")),
                        rBanGUI.getInstance().getMainMenuConfig().getConfig().getInt("items." + bansListConfig + ".item.amount"),
                        rBanGUI.getInstance().getMainMenuConfig().getConfig().getInt("items." + bansListConfig + ".item.data"));
                int slot = rBanGUI.getInstance().getMainMenuConfig().getConfig().getInt("items." + bansListConfig + ".slot");
                boolean command = rBanGUI.getInstance().getMainMenuConfig().getConfig().getBoolean("items." + bansListConfig + ".command.enabled");
                String name = rBanGUI.getInstance().getMainMenuConfig().getConfig().getString("items." + bansListConfig + ".name");
                String cmd = rBanGUI.getInstance().getMainMenuConfig().getConfig().getString("items." + bansListConfig + ".command.command");
                String type = rBanGUI.getInstance().getMainMenuConfig().getConfig().getString("items." + bansListConfig + ".action");
                BanMenuItems banMenuItem = new BanMenuItems(icon, slot, name, command, cmd ,type);
                this.banMenuItems.add(banMenuItem);
            }
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Successfully Register " + this.banMenuItems.size() + " bans menu items.");
        } catch (Exception exception) {
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Error in register ban menu items.");
            exception.getCause();
            exception.printStackTrace();
        }

        rBanGUI.getInstance().getLogger().info("[Ban-GUI] Register bans");
        try {
            for (String bansListConfig : rBanGUI.getInstance().getBanMenuConfig().getConfig().getConfigurationSection("items").getKeys(false)){
                ItemCreator icon = new ItemCreator(
                        Material.valueOf(rBanGUI.getInstance().getBanMenuConfig().getConfig().getString("items." + bansListConfig + ".item.material")),
                        rBanGUI.getInstance().getBanMenuConfig().getConfig().getInt("items." + bansListConfig + ".item.amount"),
                        rBanGUI.getInstance().getBanMenuConfig().getConfig().getInt("items." + bansListConfig + ".item.data"));
                int slot = rBanGUI.getInstance().getBanMenuConfig().getConfig().getInt("items." + bansListConfig + ".slot");
                String name = rBanGUI.getInstance().getBanMenuConfig().getConfig().getString("items." + bansListConfig + ".name");
                String command = rBanGUI.getInstance().getBanMenuConfig().getConfig().getString("items." + bansListConfig + ".command");
                List<String> lore = new ArrayList<>();
                rBanGUI.getInstance().getBanMenuConfig().getConfig().getStringList("items." + bansListConfig + ".lore").forEach(text -> lore.add(CC.translate(text)));

                Ban ban = new Ban(icon, slot, name, command, lore);
                this.banList.add(ban);
            }
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Successfully Register " + this.banList.size() + " bans.");
        } catch (Exception exception) {
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Error in register bans.");
            exception.getCause();
            exception.printStackTrace();
        }

        rBanGUI.getInstance().getLogger().info("[Ban-GUI] Register mutes");
        try {
            for (String muteListConfig : rBanGUI.getInstance().getMuteMenuConfig().getConfig().getConfigurationSection("items").getKeys(false)){
                ItemCreator icon = new ItemCreator(
                        Material.valueOf(rBanGUI.getInstance().getMuteMenuConfig().getConfig().getString("items." + muteListConfig + ".item.material")),
                        rBanGUI.getInstance().getMuteMenuConfig().getConfig().getInt("items." + muteListConfig + ".item.amount"),
                        rBanGUI.getInstance().getMuteMenuConfig().getConfig().getInt("items." + muteListConfig + ".item.data"));
                int slot = rBanGUI.getInstance().getMuteMenuConfig().getConfig().getInt("items." + muteListConfig + ".slot");
                String name = rBanGUI.getInstance().getMuteMenuConfig().getConfig().getString("items." + muteListConfig + ".name");
                String command = rBanGUI.getInstance().getMuteMenuConfig().getConfig().getString("items." + muteListConfig + ".command");
                List<String> lore = new ArrayList<>();
                rBanGUI.getInstance().getMuteMenuConfig().getConfig().getStringList("items." + muteListConfig + ".lore").forEach(text -> lore.add(CC.translate(text)));

                Mute mute = new Mute(icon, slot, name, command, lore);
                this.muteList.add(mute);
            }
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Successfully Register " + this.muteList.size() + " mutes.");
        } catch (Exception exception) {
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Error in register mutes.");
            exception.getCause();
            exception.printStackTrace();
        }

        rBanGUI.getInstance().getLogger().info("[Ban-GUI] Register warns.");
        try {
            for (String warnsListConfig : rBanGUI.getInstance().getWarnMenuConfig().getConfig().getConfigurationSection("items").getKeys(false)){
                ItemCreator icon = new ItemCreator(
                        Material.valueOf(rBanGUI.getInstance().getWarnMenuConfig().getConfig().getString("items." + warnsListConfig + ".item.material")),
                        rBanGUI.getInstance().getWarnMenuConfig().getConfig().getInt("items." + warnsListConfig + ".item.amount"),
                        rBanGUI.getInstance().getWarnMenuConfig().getConfig().getInt("items." + warnsListConfig + ".item.data"));
                int slot = rBanGUI.getInstance().getWarnMenuConfig().getConfig().getInt("items." + warnsListConfig + ".slot");
                String name = rBanGUI.getInstance().getWarnMenuConfig().getConfig().getString("items." + warnsListConfig + ".name");
                String command = rBanGUI.getInstance().getWarnMenuConfig().getConfig().getString("items." + warnsListConfig + ".command");
                List<String> lore = new ArrayList<>();
                rBanGUI.getInstance().getWarnMenuConfig().getConfig().getStringList("items." + warnsListConfig + ".lore").forEach(text -> lore.add(CC.translate(text)));

                Warn warn = new Warn(icon, slot, name, command, lore);
                this.warnList.add(warn);
            }
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Successfully Register " + this.warnList.size() + " warns.");
        } catch (Exception exception) {
            rBanGUI.getInstance().getLogger().info("[Ban-Gui] Error in register warns.");
            exception.getCause();
            exception.printStackTrace();
        }
    }
}
