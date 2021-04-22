package me.ryzeon.bangui.menu.main.button;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.manager.BanMenuItems;
import me.ryzeon.bangui.menu.submenus.BanMenu;
import me.ryzeon.bangui.menu.submenus.MuteMenu;
import me.ryzeon.bangui.menu.submenus.WarnMenu;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.gui.Button;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Ryzeon
 * Project: rUHC
 * Date: 15/10/2020 @ 13:26
 */
@AllArgsConstructor
public class MainBanButton extends Button {

    private BanMenuItems banMenuItems;

    private OfflinePlayer target;

    @Override
    public ItemStack getButtonItem(Player player) {
        return banMenuItems.getIcon().setName(banMenuItems.getName().replace("<player>", target.getName())).get();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
        switch (banMenuItems.getType()){
            case "OPEN-BAN":
                new BanMenu(target).openMenu(player);
                break;
            case "OPEN-WARN":
                new WarnMenu(target).openMenu(player);
                break;
            case "OPEN-MUTE":
                new MuteMenu(target).openMenu(player);
                break;
            case "NONE":
                if (banMenuItems.isCommand()){
                    player.performCommand(banMenuItems.getCmd().replace("<player>", target.getName()));
                    player.closeInventory();
                }
                break;
            default:
                player.sendMessage(CC.translate("&cInvalid option."));
                break;
        }
    }
}
