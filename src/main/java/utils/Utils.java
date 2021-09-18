package utils;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

/**
 * Utility class
 * @author NCBPFluffyBear
 */
public class Utils {

    public Utils() {}

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void send(CommandSender s, String msg) {
        s.sendMessage(color("&5&l[Magic] " + msg));
    }

    public static void registerEvents(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, FlowerPowerPlugin.getInstance());
    }

    public static int getExpAtLevel(int level) {
        if (level <= 15) {
            return (2 * level) + 7;
        }
        if (level <= 30) {
            return (5 * level) - 38;
        }
        return (9 * level) - 158;
    }

    public static int getTotalExperience(final Player p) {
        int currentLevel = p.getLevel();
        int exp = Math.round(getExpAtLevel(currentLevel) * p.getExp());

        while (currentLevel > 0) {
            currentLevel--;
            exp += getExpAtLevel(currentLevel);
        }
        if (exp < 0) {
            exp = 0;
        }
        return exp;
    }

    public static BukkitTask runSync(Runnable r, long delay) {

        if (Slimefun.instance() == null || !Slimefun.instance().isEnabled()) {
            return null;
        }

        return Bukkit.getScheduler().runTaskLater(Slimefun.instance(), r, delay);
    }
}
