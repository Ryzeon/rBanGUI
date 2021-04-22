package me.ryzeon.bangui.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.ryzeon.bangui.utils.ItemCreator;

import java.util.List;

/**
 * Created by Ryzeon
 * Project: rUHC
 * Date: 15/10/2020 @ 08:59
 */

@AllArgsConstructor
@Getter
@Setter
public class Ban {

    private ItemCreator icon;

    private int slot;

    private String name;

    private String command;

    private List<String> lore;
}
