package utils;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
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

    public static BukkitTask runSync(Runnable r, long delay) {

        if (SlimefunPlugin.instance() == null || !SlimefunPlugin.instance().isEnabled()) {
            return null;
        }

        return Bukkit.getScheduler().runTaskLater(SlimefunPlugin.instance(), r, delay);
    }
}
