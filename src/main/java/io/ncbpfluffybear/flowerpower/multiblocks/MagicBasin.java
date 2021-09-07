package io.ncbpfluffybear.flowerpower.multiblocks;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.multiblocks.MultiBlockMachine;
import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import io.ncbpfluffybear.flowerpower.FlowerPowerItems;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import utils.Utils;

/**
 * This is a placeholder MultiBlockMachine purely for
 * registering recipes
 * This machine can not be built due to the item frames
 * All interaction is handled by the {@link ExperienceCauldron}
 *
 * @author NCBPFluffyBear
 */
public class MagicBasin extends MultiBlockMachine {

    public static RecipeType BASIN_RECIPE;

    public MagicBasin(ItemGroup category, SlimefunItemStack item, ItemStack[] recipe, BlockFace trigger) {
        super(category, item, recipe, trigger);
    }

    @Override
    public void onInteract(Player p, Block b) {
        Utils.send(p, "&cThis shouldn't be able to happen.");
    }

    static {
        BASIN_RECIPE = new RecipeType(new NamespacedKey(FlowerPowerPlugin.getInstance(),
                "magic_basin"), FlowerPowerItems.MAGIC_BASIN,"&7Craft it with a Magic Basin!"
        );
    }
}
