package me.ryzeon.bangui.utils;

import org.bukkit.ChatColor;

import java.awt.*;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Ryzeon
 * Project: CaosBanGUI
 * Date: 2/11/2020 @ 11:25
 */

public class CC {
    public static String translate(String source) {
        return ChatColor.translateAlternateColorCodes('&', source);
    }

    public static List<String> translate(List<String> source) {
        return (List<String>)source.stream().map(CC::translate).collect(Collectors.toList());
    }

    public static Color getRandomColor() {
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        return new Color(r, g, b);
    }
}
