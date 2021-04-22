package me.ryzeon.bangui.menu.submenus.button;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.rBanGUI;
import me.ryzeon.bangui.manager.Ban;
import me.ryzeon.bangui.utils.config.ConfigCursor;
import me.ryzeon.bangui.utils.config.FileConfig;
import me.ryzeon.bangui.utils.discord.DiscordWebhook;
import me.ryzeon.bangui.utils.gui.Button;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryzeon
 * Project: rUHC
 * Date: 16/10/2020 @ 21:09
 */

@AllArgsConstructor
public class BanButton extends Button {

    private OfflinePlayer target;

    private Ban ban;

    @Override
    public ItemStack getButtonItem(Player player) {
        List<String> lorexd = new ArrayList<>();
        ban.getLore().forEach(text -> lorexd.add(text.replace("<player>", target.getName())));

        return ban.getIcon()
                .setLore(lorexd)
                .setName(ban.getName().replace("<player>", target.getName()))
                .get();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
        FileConfig fileConfig = rBanGUI.getInstance().getMainConfig();
        ConfigCursor discord = new ConfigCursor(fileConfig, "DISCORD");
        String name = ban.getName().replace("&", "§");
        player.performCommand(ban.getCommand().replace("<player>", target.getName()));
        player.closeInventory();
        if (discord.getBoolean("ENABLED")) {
            try {
                DiscordWebhook webhook = new DiscordWebhook(discord.getString("URL"));
                webhook.setAvatarUrl(discord.getString("IMAGE"));
                webhook.setUsername(discord.getString("NAME"));
                webhook.setTts(false);
                webhook.addEmbed(new DiscordWebhook.EmbedObject()
                        .setTitle("Ban Alert")
                        .setColor(Color.RED)
                        .addField("Server:", rBanGUI.getInstance().getMainConfig().getConfig().getString("SERVER-NAME"), true)
                        .addField("Staff:", player.getName(), true)
                        .addField("Player:", target.getName(), true)
                        .addField("Reason:", ChatColor.stripColor(name), true)
                        .setFooter(discord.getString("FOOTER"), discord.getString("IMAGE"))
                        .setThumbnail("https://minotar.net/avatar/" + player.getName()));
                webhook.execute();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
