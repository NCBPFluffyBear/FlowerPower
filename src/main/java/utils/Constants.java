package utils;

import io.ncbpfluffybear.flowerpower.FlowerPowerPlugin;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Stores plugin constants
 * @author NCBPFluffyBear
 */
public class Constants {

    public Constants() {}

    public static final NamespacedKey GLOW_ENCHANT = new NamespacedKey(FlowerPowerPlugin.getInstance(),
            "flowerpower_glow_enchant");

    public static final Set<Material> flowers = new LinkedHashSet<>(Arrays.asList(
            Material.POPPY, Material.DANDELION, Material.OXEYE_DAISY, Material.ALLIUM));

}
