package utils;

import org.bukkit.inventory.ItemStack;

import java.util.Comparator;

/**
 * A comparator that is used to sort {@link io.ncbpfluffybear.flowerpower.multiblocks.MagicBasin}
 * recipes to compare recipes
 * @author NCBPFluffyBear
 */
public class ItemStackComparator implements Comparator<ItemStack> {
    @Override
    public int compare(ItemStack item1, ItemStack item2) {
        return item1.toString().compareTo(item2.toString());
    }
}
