package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.Utils;

/**
 * Holds large amounts of experience
 * Inspired by Thermal Foundation's Tome of Knowledge
 *
 * @author NCBPFluffyBear
 */
public class ExperienceTome extends SlimefunItem implements Listener {

    private static final NamespacedKey expAmount = new NamespacedKey(FlowerPowerPlugin.getInstance(), "exp-amount");
    private static final int MAX_EXP = 1000000;
    private static final int EXP_TRANSFER_RATE = 10;

    public ExperienceTome(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        Utils.registerEvents(this);
    }

    @EventHandler
    private void onTomeUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        ItemStack tome = e.getItem();

        // Check if item is a tome
        if (!isItem(tome)) {
            return;
        }

        if (!this.canUse(p, true)) {
            return;
        }

        e.setCancelled(true);

        if (tome == null) {
            return;
        }

        ItemMeta tomeMeta = tome.getItemMeta();
        int tomeExp = PersistentDataAPI.getInt(tomeMeta, expAmount, 0);

        // Exp extraction
        if (p.isSneaking()) {

            // Check if the exp can be extracted from tome
            if (tomeExp == 0) {
                Utils.send(p, "&cThis Experience Tome is empty!");
                return;
            }

            int transferExp;

            // Left click is max withdraw
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                transferExp = tomeExp;
            } else {
                transferExp = Math.min(tomeExp, EXP_TRANSFER_RATE);
            }

            // Add Exp to player
            PersistentDataAPI.setInt(tomeMeta, expAmount, tomeExp -= transferExp);
            p.giveExp(transferExp);
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        } else {

            if (Utils.getTotalExperience(p) == 0) {
                Utils.send(p, "&cYou don't have enough exp!");
                return;
            }

            int transferExp;

            // Left click is max insert
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                transferExp = Utils.getTotalExperience(p);
            } else {
                transferExp = Math.min(Utils.getTotalExperience(p), EXP_TRANSFER_RATE);
            }

            // If overflow, decrease to fill tome
            if (transferExp + tomeExp > MAX_EXP) {
                transferExp = MAX_EXP - tomeExp;
            }

            // Check if exp can be added to the tome
            if (tomeExp + transferExp > MAX_EXP || transferExp == 0) {
                Utils.send(p, "&cThis Experience Tome is full!");
                return;
            }

            // Add Exp to player
            PersistentDataAPI.setInt(tomeMeta, expAmount, tomeExp += transferExp);
            p.giveExp(-transferExp);
            p.playSound(p.getLocation(), Sound.ENTITY_DROWNED_AMBIENT_WATER, 1, 1);
        }

        // Update name to display stored amount
        tomeMeta.setDisplayName(Utils.color("&eExperience Tome &a(" + tomeExp + " / 1000000)"));
        tome.setItemMeta(tomeMeta);
    }
}
