package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.ncbpfluffybear.flowerpower.objects.FPNotPlaceable;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import utils.Utils;

import javax.annotation.Nonnull;

/**
 * A "consumable" food that consumes experience
 * instead of the item
 *
 * @author NCBPFluffyBear
 */
public class InfinityApple extends SimpleSlimefunItem<ItemUseHandler> implements FPNotPlaceable, NotPlaceable {

    public static final int FOOD_PER_CONSUME = 1;
    public static final int EXP_PER_CONSUME = 1;

    public InfinityApple(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            int exp = Utils.getTotalExperience(p);
            int foodLevel = p.getFoodLevel();

            // Check if player has enough exp
            if (exp < EXP_PER_CONSUME) {
                Utils.send(p, "&cYou can not afford this! Needed exp points: " + EXP_PER_CONSUME);
                return;
            }

            // Check if player needs food
            if (foodLevel > 20) {
                Utils.send(p, "&cYou are already full!");
                return;
            }

            // Consume exp and feed player
            p.giveExp(-EXP_PER_CONSUME);
            p.setFoodLevel(foodLevel + FOOD_PER_CONSUME);

            p.playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1, 1);

        };
    }
}
