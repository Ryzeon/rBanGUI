package me.ryzeon.bangui.utils.command;

import lombok.Setter;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.TaskUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Setter
public class rCommand extends BukkitCommand {
    private boolean forPlayersOnly;

    private boolean async;

    private String permission;

    public rCommand(String name) {
        this(name, new ArrayList<>());
    }

    public rCommand(String name, List<String> aliases) {
        this(name, aliases, null, false);
    }

    public rCommand(String name, String permission) {
        this(name, new ArrayList<>(), permission);
    }

    public rCommand(String name, String permission, List<String> aliases) {
        this(name, aliases, permission);
    }

    public rCommand(String name, List<String> aliases, String permission) {
        this(name, aliases, permission, false);
    }

    public rCommand(String name, boolean forPlayersOnly) {
        this(name, new ArrayList<>(), null, forPlayersOnly);
    }

    public rCommand(String name, List<String> aliases, boolean forPlayersOnly) {
        this(name, aliases, null, forPlayersOnly);
    }

    public rCommand(String name, String permission, boolean forPlayersOnly) {
        this(name, new ArrayList<>(), permission, forPlayersOnly);
    }

    public rCommand(String name, List<String> aliases, String permission, boolean forPlayersOnly) {
        super(name);
        setAliases(aliases);
        this.permission = permission;
        this.forPlayersOnly = forPlayersOnly;
    }

    public boolean execute(CommandSender sender, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            if (this.forPlayersOnly) {
                sender.sendMessage(CC.translate("&cOnly for players."));
                return true;
            }
            if (this.async) {
                TaskUtil.runAsync(() -> execute(sender, args));
            } else {
                execute(sender, args);
            }
            return true;
        }
        Player player = (Player) sender;
        if (!checkPermission(sender, this.permission)) {
            sender.sendMessage(CC.translate("&cYou don't have permissions."));
            return false;
        }
        if (this.async) {
            TaskUtil.runAsync(() -> {
                execute(player, args);
                execute(sender, args);
            });
        } else {
            execute(player, args);
            execute(sender, args);
        }
        return true;
    }

    public void execute(CommandSender sender, String[] args) {

    }

    public void execute(Player player, String[] args) {

    }

    private boolean checkPermission(CommandSender sender, String permission) {
        if (!(sender instanceof Player)) return true;
        if (permission == null) return true;

        return sender.hasPermission(permission);
    }
}