package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.Utils;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

/**
 * An item that allows players to bind locations
 * and teleport back to them for an exp cost
 *
 * @author NCBPFluffyBear
 */
public class RecallCharm extends SimpleSlimefunItem<ItemUseHandler> {

    public static final int TELEPORT_COST = 50;
    private static final int LORE_INDEX = 7;
    private static final NamespacedKey location = new NamespacedKey(FlowerPowerPlugin.getInstance(), "location");

    public RecallCharm(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            e.cancel();

            if (e.getInteractEvent().getAction() == Action.RIGHT_CLICK_BLOCK) {
                return;
            }

            Player p = e.getPlayer();
            ItemStack charm = e.getItem();
            ItemMeta charmMeta = charm.getItemMeta();

            // Assign teleport location mode
            if (p.isSneaking()) {
                Location l = p.getLocation();

                if (!Slimefun.getProtectionManager().hasPermission(p, l.getBlock(), Interaction.INTERACT_BLOCK)) {
                    Utils.send(p, "You do not have permission to bind your Recall Charm here!");
                    return;
                }

                // Store location info into PDC
                PersistentDataAPI.setString(charmMeta, location, l.getWorld().getUID() + "_" +
                        l.getBlockX() + "_" + l.getBlockY() + "_" + l.getBlockZ());

                // Put location info into lore
                List<String> lore = charmMeta.getLore();
                lore.set(LORE_INDEX, Utils.color("&3Bound Location: " + l.getWorld().getName() + " @ " +
                        l.getBlockX() + ", " + l.getBlockY() + ", " + l.getBlockZ()));
                charmMeta.setLore(lore);
                charm.setItemMeta(charmMeta);

                Utils.send(p, "&aYour recall charm has been bound to your current location");
                return;
            }

            // Teleport player

            // Check if player has sufficient exp
            if (Utils.getTotalExperience(p) < TELEPORT_COST) {
                Utils.send(p, "&cYou can not afford to teleport! Needed exp points: " + TELEPORT_COST);
                return;
            }

            String locationDat = PersistentDataAPI.getString(charmMeta, location);

            // Charm not bound yet
            if (locationDat == null) {
                Utils.send(p, "&cThis recall charm has not been bound yet!");
                return;
            }

            // Parse location data
            String[] location = locationDat.split("_");

            // Consume exp and teleport player
            p.giveExp(-TELEPORT_COST);
            p.teleport(new Location(Bukkit.getWorld(UUID.fromString(location[0])),
                    Integer.parseInt(location[1]) + 0.5, Integer.parseInt(location[2]),
                    Integer.parseInt(location[3]) + 0.5
            ));
            p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);

            Utils.send(p, "&aYou have teleported successfully");
        };
    }
}
