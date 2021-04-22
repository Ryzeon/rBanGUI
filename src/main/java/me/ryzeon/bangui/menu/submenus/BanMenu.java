package me.ryzeon.bangui.menu.submenus;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.rBanGUI;
import me.ryzeon.bangui.manager.Ban;
import me.ryzeon.bangui.menu.submenus.button.BanButton;
import me.ryzeon.bangui.utils.CC;
import me.ryzeon.bangui.utils.gui.Button;
import me.ryzeon.bangui.utils.gui.Menu;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ryzeon
 * Project: rBanGUI
 * Date: 16/10/2020 @ 21:09
 */

@AllArgsConstructor
public class BanMenu extends Menu {

    private OfflinePlayer target;

    @Override
    public String getTitle(Player player) {
        return CC.translate(rBanGUI.getInstance().getBanMenuConfig().getConfig().getString("title").replace("<player>", target.getName()));
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        for (Ban ban : rBanGUI.getInstance().getBanMenuManager().getBanList()){
            buttonMap.put(ban.getSlot(), new BanButton(target, ban));
        }

        setPlaceholder(true);

        return buttonMap;
    }

    @Override
    public int getSize() {
        return rBanGUI.getInstance().getBanMenuConfig().getConfig().getInt("size");
    }
}
