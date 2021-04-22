package me.ryzeon.bangui;

import lombok.Getter;
import me.ryzeon.bangui.command.BanGUICommand;
import me.ryzeon.bangui.manager.BanMenuManager;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.ItemCreator;
import me.ryzeon.bangui.utils.command.rCommand;
import me.ryzeon.bangui.utils.config.FileConfig;
import me.ryzeon.bangui.utils.gui.ButtonListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Ryzeon
 * Project: me.ryzeon.bangui.rBanGUI
 * Date: 22/01/2021 @ 10:52
 */

@Getter
public class rBanGUI extends JavaPlugin {

    @Getter private static rBanGUI instance;

    protected FileConfig
            mainConfig,
            banMenuConfig,
            warnMenuConfig,
            muteMenuConfig,
            mainMenuConfig;

    private BanMenuManager banMenuManager;

    @Override
    public void onEnable() {
        instance = this;
        this.mainConfig = new FileConfig(this, "config.yml");
        this.banMenuConfig = new FileConfig(this, "ban-gui/ban.yml");
        this.muteMenuConfig = new FileConfig(this, "ban-gui/mute.yml");
        this.warnMenuConfig = new FileConfig(this, "ban-gui/warn.yml");
        this.mainMenuConfig = new FileConfig(this, "ban-gui/menu.yml");
        this.banMenuManager = new BanMenuManager();
        banMenuManager.register();

        ItemCreator.registerGlow();
        Bukkit.getPluginManager().registerEvents(new ButtonListener(), this);
        Bukkit.getConsoleSender().sendMessage(CC.translate("&erBanGUI by @Ryzeon_"));
        registerCommands(
                new BanGUICommand()
        );

    }

    private void registerCommands(rCommand... baseCommands) {
        CommandMap commandMap;
        try {
            Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
        } catch (Exception e) {
            instance.getLogger().info("[rLoader] [Command] Error in register command.");
            return;
        }
        Arrays.stream(baseCommands).forEach(baseCommand -> {
            commandMap.register(instance.getName(), baseCommand);
        });
    }
}
