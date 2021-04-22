package me.ryzeon.bangui.utils.gui.buttons;

import lombok.AllArgsConstructor;
import me.ryzeon.bangui.utils.ItemCreator;
import me.ryzeon.bangui.utils.gui.Button;
import me.ryzeon.bangui.utils.gui.pagination.PaginatedMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

/**
 * Created by Ryzeon
 * Project: Zoom [Core]
 * Date: 11/10/2020 @ 20:26
 */

@AllArgsConstructor
public class PageInfoButton extends Button {

    private PaginatedMenu paginatedMenu;

    @Override
    public ItemStack getButtonItem(Player player) {
        return new ItemCreator(Material.NETHER_STAR)
                .setName("&ePage Info")
                .setLore(Collections.singletonList("&e" + paginatedMenu.getPage() + "&7/&a" + paginatedMenu.getPages(player)))
                .glow()
                .get();
    }

    @Override
    public boolean shouldCancel(Player player, int slot, ClickType clickType) {
        return true;
    }
}
