package io.ncbpfluffybear.flowerpower;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.ncbpfluffybear.flowerpower.items.InfinityApple;
import io.ncbpfluffybear.flowerpower.items.InfinityBandage;
import io.ncbpfluffybear.flowerpower.items.RecallCharm;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import utils.Constants;
import utils.ItemTags;

/**
 * SlimefunItemStack registration
 * @author NCBPFluffyBear
 */
public class FlowerPowerItems {

    public static final ItemGroup FLOWERPOWER_CATEGORY = new ItemGroup(new NamespacedKey(FlowerPowerPlugin.getInstance(),
            "flowerpower_category"), new CustomItemStack(Material.ALLIUM, "&5Flower Power")
    );
    // Multiblocks
    public static final SlimefunItemStack MAGIC_BASIN = new SlimefunItemStack("MAGIC_BASIN",
            Material.CAULDRON,
            "&bMagic Basin",
            "",
            "&7&oA basin used to make magical items",
            "",
            "&eRight click &7with a Magic Wand to activate",
            ItemTags.MULTIBLOCK
    );
    // Blocks
    public static final SlimefunItemStack EXPERIENCE_CAULDRON = new SlimefunItemStack("EXPERIENCE_CAULDRON",
            Material.CAULDRON,
            "&aExperience Cauldron",
            "",
            "&7&oA block that stores experience",
            "&7&oUsed to make a Magic Basin",
            "",
            "&eRight Click &7to deposit exp",
            "&eSneak and Right Click &7to withdraw exp",
            ItemTags.MULTIBLOCK
    );
    // Glistening Flowers
    public static final SlimefunItemStack GLISTENING_POPPY = new SlimefunItemStack("GLISTENING_POPPY",
            Material.POPPY,
            "&aGlistening Poppy",
            "",
            "&7&oA glowing poppy",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack GLISTENING_DANDELION = new SlimefunItemStack("GLISTENING_DANDELION",
            Material.DANDELION,
            "&aGlistening Dandelion",
            "",
            "&7&oA glowing dandelion",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack GLISTENING_OXEYE_DAISY = new SlimefunItemStack("GLISTENING_OXEYE_DAISY",
            Material.OXEYE_DAISY,
            "&aGlistening Oxeye Daisy",
            "",
            "&7&oA glowing oxeye daisy",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack GLISTENING_ALLIUM = new SlimefunItemStack("GLISTENING_ALLIUM",
            Material.ALLIUM,
            "&aGlistening Allium",
            "",
            "&7&oA glowing allium",
            "",
            ItemTags.CRAFTING_ITEM
    );
    // Items
    public static final SlimefunItemStack MAGICAL_WAND = new SlimefunItemStack("MAGICAL_WAND",
            Material.BLAZE_ROD,
            "&5Magical Wand",
            "",
            "&eRight Click &7on a Magic Basin",
            "&7to start it",
            "",
            ItemTags.TOOL
    );
    public static final SlimefunItemStack MAGIC_CREAM = new SlimefunItemStack("MAGIC_CREAM",
            Material.MAGMA_CREAM,
            "&6&lMagic Cream",
            "",
            "&7&oA slimy ball with magical properties",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack OVERGROWTH_SEED = new SlimefunItemStack("OVERGROWTH_SEED",
            Material.WHEAT_SEEDS,
            "&3Flowering Seed",
            "",
            "",
            "&eRight click &7on compatible flowers to",
            "&7produce multiple copies of it",
            "",
            ItemTags.MAGICAL_ITEM
    );
    // Flower Crystals
    public static final SlimefunItemStack RED_CRYSTAL = new SlimefunItemStack("RED_CRYSTAL",
            Material.RED_GLAZED_TERRACOTTA,
            "&cRed Crystal",
            "",
            "&7&oThis looks shiny...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack YELLOW_CRYSTAL = new SlimefunItemStack("YELLOW_CRYSTAL",
            Material.YELLOW_GLAZED_TERRACOTTA,
            "&eYellow Crystal",
            "",
            "&7&oThis looks shiny...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack WHITE_CRYSTAL = new SlimefunItemStack("WHITE_CRYSTAL",
            Material.WHITE_GLAZED_TERRACOTTA,
            "&fWhite Crystal",
            "",
            "&7&oThis looks shiny...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack PURPLE_CRYSTAL = new SlimefunItemStack("PURPLE_CRYSTAL",
            Material.PURPLE_GLAZED_TERRACOTTA,
            "&5Purple Crystal",
            "",
            "&7&oThis looks shiny...",
            "",
            ItemTags.CRAFTING_ITEM
    );
    public static final SlimefunItemStack MOVEMENT_SPEED_CHARM = new SlimefunItemStack("MOVEMENT_SPEED_CHARM",
            Material.SUGAR,
            "&aMovement Speed Charm",
            "",
            "&eRight click &cto inspect this charm",
            "&7&oHold this charm in your offhand to run faster",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack ATTACK_SPEED_CHARM = new SlimefunItemStack("ATTACK_SPEED_CHARM",
            Material.SUGAR,
            "&aAttack Speed Charm",
            "",
            "&eRight click &cto inspect this charm",
            "&7&oHold this charm in your offhand to attack faster",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack FLY_SPEED_CHARM = new SlimefunItemStack("FLY_SPEED_CHARM",
            Material.SUGAR,
            "&aFly Speed Charm",
            "",
            "&eRight click &cto inspect this charm",
            "&7&oHold this charm in your offhand to fly faster",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack DAMAGE_CHARM = new SlimefunItemStack("DAMAGE_CHARM",
            Material.SUGAR,
            "&aDamage Charm",
            "",
            "&eRight click &cto inspect this charm",
            "&7&oHold this charm in your offhand to deal more damage",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack HEALTH_CHARM = new SlimefunItemStack("HEALTH_CHARM",
            Material.SUGAR,
            "&aHealth Charm",
            "",
            "&eRight click &cto inspect this charm",
            "&7&oHold this charm in your offhand to gain more hearts",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack EXPERIENCE_TOME = new SlimefunItemStack("EXPERIENCE_TOME",
            Material.ENCHANTED_BOOK,
            "&eExperience Tome &a(0 / 1000000)",
            "",
            "&7&oCapable of holding massive amounts of experience",
            "",
            "&eRight click &7to insert exp",
            "&eSneak and Right Click &7to extract exp",
            "&eLeft click &7to perform actions in bulk",
            "",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack INFINITY_APPLE = new SlimefunItemStack("INFINITY_APPLE",
            new CustomItemStack(SlimefunUtils.getCustomHead("99a79d7e5d1ba739ab4471643e744ef781f7c1d4ea52efc99168d6cb5732326")),
            "&eInfinity Apple",
            "",
            "&7&oConverts experience to food",
            "",
            "&eRight Click &7to eat",
            "",
            "&aCost: " + InfinityApple.EXP_PER_CONSUME + " exp point per " + InfinityApple.FOOD_PER_CONSUME + " hunger",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack INFINITY_BANDAGE = new SlimefunItemStack("INFINITY_BANDAGE",
            Material.PAPER,
            "&cInfinity Bandage",
            "",
            "&7&oConverts experience to health",
            "",
            "&eRight Click &7to heal",
            "",
            "&aCost: " + InfinityBandage.EXP_PER_CONSUME + " exp points per " + InfinityBandage.HEALTH_PER_CONSUME + " health",
            ItemTags.MAGICAL_ITEM
    );
    public static final SlimefunItemStack RECALL_CHARM = new SlimefunItemStack("RECALL_CHARM",
            Material.ENDER_EYE,
            "&5Recall Charm",
            "",
            "&7&oTeleports you back to a remembered location",
            "&7&oin exchange for experience...",
            "",
            "&eSneak and Right Click &7to bind current location",
            "&eRight Click &7to teleport",
            "",
            "&3Bound Location: None",
            "",
            "&aCost: " + RecallCharm.TELEPORT_COST + " exp points per teleport",
            ItemTags.MAGICAL_ITEM
    );


    private static final Enchantment glowEnchant = Enchantment.getByKey(Constants.GLOW_ENCHANT);

    static {
        GLISTENING_POPPY.addEnchantment(glowEnchant, 1);
        GLISTENING_DANDELION.addEnchantment(glowEnchant, 1);
        GLISTENING_OXEYE_DAISY.addEnchantment(glowEnchant, 1);
        GLISTENING_ALLIUM.addEnchantment(glowEnchant, 1);

        OVERGROWTH_SEED.addEnchantment(glowEnchant, 1);
        INFINITY_BANDAGE.addEnchantment(glowEnchant, 1);
        RECALL_CHARM.addEnchantment(glowEnchant, 1);
    }


    private FlowerPowerItems() {
    }

}
