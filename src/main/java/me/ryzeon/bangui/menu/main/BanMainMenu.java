package me.ryzeon.bangui.menu.main;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.rBanGUI;
import me.ryzeon.bangui.manager.BanMenuItems;
import me.ryzeon.bangui.menu.main.button.MainBanButton;
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
 * Date: 15/10/2020 @ 08:54
 */

@AllArgsConstructor
public class BanMainMenu extends Menu {

    private OfflinePlayer target;

    @Override
    public String getTitle(Player player) {
        return CC.translate(rBanGUI.getInstance().getMainMenuConfig().getConfig().getString("title"));
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        for (BanMenuItems menuItems : rBanGUI.getInstance().getBanMenuManager().getBanMenuItems()){
            buttonMap.put(menuItems.getSlot(), new MainBanButton(menuItems, target));
        }

        setPlaceholder(true);

        return buttonMap;
    }

    @Override
    public int getSize() {
        return rBanGUI.getInstance().getMainMenuConfig().getConfig().getInt("size");
    }
}
