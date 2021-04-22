package me.ryzeon.bangui.menu.submenus;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.manager.Warn;
import me.ryzeon.bangui.menu.submenus.button.WarnButton;
import me.ryzeon.bangui.rBanGUI;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.gui.Button;
import me.ryzeon.bangui.utils.gui.Menu;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryzeon
 * Project: rUHC
 * Date: 16/10/2020 @ 21:42
 */

@AllArgsConstructor
public class WarnMenu extends Menu {

    private OfflinePlayer target;

    @Override
    public String getTitle(Player player) {
        return CC.translate(rBanGUI.getInstance().getWarnMenuConfig().getConfig().getString("title").replace("<player>", target.getName()));
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        for (Warn warn : rBanGUI.getInstance().getBanMenuManager().getWarnList()){
            buttonMap.put(warn.getSlot(), new WarnButton(target, warn));
        }

        setPlaceholder(true);

        return buttonMap;
    }

    @Override
    public int getSize() {
        return rBanGUI.getInstance().getWarnMenuConfig().getConfig().getInt("size");
    }
}
