package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utils.Utils;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Charms are held in the offhand to provide
 * various buffs to the player
 *
 * @author NCBPFluffyBear
 */
public class AttributeCharms extends SimpleSlimefunItem<ItemUseHandler> implements Listener {

    private static final NamespacedKey inspectedKey = new NamespacedKey(FlowerPowerPlugin.getInstance(), "inspected");
    private static final int LORE_INDEX = 1;

    private final Charm type;

    public AttributeCharms(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Charm type) {
        super(category, item, recipeType, recipe);
        this.type = type;

        Utils.registerEvents(this);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            ItemStack charm = e.getItem();
            ItemMeta charmMeta = charm.getItemMeta();
            Player p = e.getPlayer();

            // Don't reinspect charms
            if (PersistentDataAPI.getByte(charmMeta, inspectedKey, (byte) 0) == 1) {
                return;
            }

            // Add specified attribute to offhand
            double level = ThreadLocalRandom.current().nextDouble(type.minLvl, type.maxLvl);
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), type.attribute.getKey().getKey(),
                    level, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
            charmMeta.addAttributeModifier(type.attribute, modifier);

            // Update lore
            List<String> lore = charmMeta.getLore();
            lore.set(LORE_INDEX, Utils.color("&aThis charm has been inspected"));
            charmMeta.setLore(lore);

            p.playSound(p.getLocation(), Sound.BLOCK_BELL_RESONATE, 1, 1);

            // Set inspected status to true
            PersistentDataAPI.setByte(charmMeta, inspectedKey, (byte) 1);
            charm.setItemMeta(charmMeta);

        };
    }

    public enum Charm {

        MOVEMENT_SPEED(Attribute.GENERIC_MOVEMENT_SPEED, 0.01, 0.2),
        ATTACK_SPEED(Attribute.GENERIC_ATTACK_SPEED, 0.1, 0.5),
        FLY_SPEED(Attribute.GENERIC_FLYING_SPEED, 0.01, 0.3),
        DAMAGE(Attribute.GENERIC_ATTACK_DAMAGE, 0.01, 0.5),
        MAX_HEALTH(Attribute.GENERIC_MAX_HEALTH, 1, 5);

        private final Attribute attribute;
        private final double minLvl;
        private final double maxLvl;

        Charm(Attribute attribute, double minLvl, double maxLvl) {
            this.attribute = attribute;
            this.minLvl = minLvl;
            this.maxLvl = maxLvl;
        }
    }
}
