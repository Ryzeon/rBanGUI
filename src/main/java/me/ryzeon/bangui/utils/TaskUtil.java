package me.ryzeon.bangui.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import me.ryzeon.bangui.rBanGUI;

import java.util.concurrent.ThreadFactory;

public class TaskUtil {
    public static ThreadFactory newThreadFactory(String name) {
        return (new ThreadFactoryBuilder()).setNameFormat(name).build();
    }

    public static void run(Callable callable) {
        rBanGUI.getInstance().getServer().getScheduler().runTask(rBanGUI.getInstance(), callable::call);
    }

    public static void runAsync(Callable callable) {
        rBanGUI.getInstance().getServer().getScheduler().runTaskAsynchronously(rBanGUI.getInstance(), callable::call);
    }

    public static void runLater(Callable callable, long delay) {
        rBanGUI.getInstance().getServer().getScheduler().runTaskLater(rBanGUI.getInstance(), callable::call, delay);
    }

    public static void runAsyncLater(Callable callable, long delay) {
        rBanGUI.getInstance().getServer().getScheduler().runTaskLaterAsynchronously(rBanGUI.getInstance(), callable::call, delay);
    }

    public static void runTimer(Callable callable, long delay, long interval) {
        rBanGUI.getInstance().getServer().getScheduler().runTaskTimer(rBanGUI.getInstance(), callable::call, delay, interval);
    }

    public static void runAsyncTimer(Callable callable, long delay, long interval) {
        rBanGUI.getInstance().getServer().getScheduler().runTaskTimerAsynchronously(rBanGUI.getInstance(), callable::call, delay, interval);
    }

    public static interface Callable {
        void call();
    }
}
