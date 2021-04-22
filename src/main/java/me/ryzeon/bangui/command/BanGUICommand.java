package me.ryzeon.bangui.command;

import me.ryzeon.bangui.menu.main.BanMainMenu;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.command.rCommand;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Arrays;

/**
 * Created by Ryzeon
 * Project: rBanGUI
 * Date: 22/01/2021 @ 11:06
 */

public class BanGUICommand extends rCommand {

    public BanGUICommand(){
        super("bangui","core.staff", Arrays.asList("pgui", "pban", "bgui", "gban", "p"));
        setForPlayersOnly(true);
    }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length < 1) {
            player.sendMessage(CC.translate("/" + this.getLabel() + " <player>"));
            player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1F,1F);
            return;
        }
        OfflinePlayer offlinePlayer = Bukkit.getServer().getOfflinePlayer(args[0]);
        new BanMainMenu(offlinePlayer).openMenu(player);
    }
}
