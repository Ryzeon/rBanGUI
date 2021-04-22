package me.ryzeon.bangui.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.ryzeon.bangui.utils.ItemCreator;

/**
 * Created by Ryzeon
 * Project: rUHC
 * Date: 15/10/2020 @ 11:42
 */

@AllArgsConstructor
@Getter
@Setter
public class BanMenuItems {

    private ItemCreator icon;

    private int slot;

    private String name;

    private boolean command;

    private String cmd;

    private String type;
}