package io.ncbpfluffybear.flowerpower.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import utils.Constants;
import utils.Utils;

import javax.annotation.Nonnull;
import java.util.Optional;

/**
 * An item that is used to produce more flowers
 * to help with player progression
 *
 * @author NCBPFluffyBear
 */
public class OvergrowthSeed extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    private final ItemSetting<Integer> duplicateAmount = new ItemSetting<>(this, "duplicate-amount", 5);

    public OvergrowthSeed(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);

        addItemSetting(duplicateAmount);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            e.cancel();

            Optional<Block> optB = e.getClickedBlock();

            if (!optB.isPresent()) {
                return;
            }

            Block b = optB.get();
            Player p = e.getPlayer();

            // Check if it is one of the 4 acceptable flowers
            if (!Constants.flowers.contains(b.getType())) {
                Utils.send(p, "&cYou can not use this on this block");
                return;
            }

            // Consume one overgrowth seed
            ItemStack seed = e.getItem();
            seed.setAmount(seed.getAmount() - 1);

            // Duplicate and drop flowers
            b.getWorld().dropItem(b.getLocation(), new ItemStack(b.getType(), duplicateAmount.getValue()));

            p.playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);

            Utils.send(p, "&aThis flower starts to grow quickly...");

        };
    }
}
