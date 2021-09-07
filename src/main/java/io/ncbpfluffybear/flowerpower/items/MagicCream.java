package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.attributes.RandomMobDrop;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

/**
 * An essential starting crafting ingredient
 * dropped by slimes as a {@link RandomMobDrop}
 *
 * @author NCBPFluffyBear
 */
public class MagicCream extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable, RandomMobDrop {

    private final ItemSetting<Integer> dropChance = new ItemSetting<>(this, "drop-chance", 50);

    public MagicCream(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        addItemSetting(dropChance);
    }

    @Override
    public int getMobDropChance() {
        return dropChance.getValue();
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return PlayerRightClickEvent::cancel;
    }
}
