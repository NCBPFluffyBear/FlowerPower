package listeners;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.ncbpfluffybear.flowerpower.objects.FPNotPlaceable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Stores the general events for the {@link io.ncbpfluffybear.flowerpower.FlowerPowerPlugin}
 * @author NCBPFluffyBear
 */

public class Events implements Listener {

    public Events() {}

    /**
     * Prevents {@link FPNotPlaceable} items from being placed
     */
    @EventHandler
    private void onFPNotPlaceablePlace(BlockPlaceEvent e) {
        ItemStack item = e.getItemInHand();
        SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if (sfItem instanceof FPNotPlaceable) {
            e.setCancelled(true);
        }
    }

}
