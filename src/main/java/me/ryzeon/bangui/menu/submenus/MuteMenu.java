package me.ryzeon.bangui.menu.submenus;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.manager.Mute;
import me.ryzeon.bangui.menu.submenus.button.MuteButton;
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
 * Date: 16/10/2020 @ 21:38
 */

@AllArgsConstructor
public class MuteMenu extends Menu {

    private OfflinePlayer target;

    @Override
    public String getTitle(Player player) {
        return CC.translate(rBanGUI.getInstance().getMuteMenuConfig().getConfig().getString("title").replace("<player>", target.getName()));
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttonMap = new HashMap<>();

        for (Mute mute : rBanGUI.getInstance().getBanMenuManager().getMuteList()){
            buttonMap.put(mute.getSlot(), new MuteButton(target, mute));
        }

        setPlaceholder(true);

        return buttonMap;
    }

    @Override
    public int getSize() {
        return rBanGUI.getInstance().getMuteMenuConfig().getConfig().getInt("size");
    }
}
