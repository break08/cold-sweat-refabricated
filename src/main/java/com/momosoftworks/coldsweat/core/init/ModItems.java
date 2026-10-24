package com.momosoftworks.coldsweat.core.init;

import com.momosoftworks.coldsweat.ColdSweat;
import com.momosoftworks.coldsweat.common.block.*;
import com.momosoftworks.coldsweat.common.item.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems
{
    // Items
    public static final Item WATERSKIN = register(new WaterskinItem(), "waterskin");
    public static final Item FILLED_WATERSKIN = register(new FilledWaterskinItem(), "filled_waterskin");
    public static final Item MINECART_INSULATION = register(new MinecartInsulationItem(), "minecart_insulation");
    public static final Item THERMOMETER = register(
            new ThermometerItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)), "thermometer");
    public static final Item SOULSPRING_LAMP = register(new SoulspringLampItem(), "soulspring_lamp");
    public static final Item GOAT_FUR = register(new Item(new Item.Properties()), "goat_fur");
    public static final Item HOGLIN_HIDE = register(new Item(new Item.Properties()), "hoglin_hide");
    public static final Item INSULATED_MINECART = register(
            new InsulatedMinecartItem(new Item.Properties().stacksTo(1)), "insulated_minecart");
    public static final Item CHAMELEON_MOLT = register(new Item(new Item.Properties()), "chameleon_molt");
    public static final Item SLUSH_BUCKET = register(
            new BucketItem(ModFluids.SLUSH, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)),
            "slush_bucket");

    // Armor Items
    public static final Item HOGLIN_HELMET = register(
            new HoglinArmorItem(ModArmorMaterials.HOGLIN, ArmorItem.Type.HELMET, armorProps(ArmorItem.Type.HELMET, 14)), "hoglin_helmet");
    public static final Item HOGLIN_CHESTPLATE = register(
            new HoglinArmorItem(ModArmorMaterials.HOGLIN, ArmorItem.Type.CHESTPLATE, armorProps(ArmorItem.Type.CHESTPLATE, 14)), "hoglin_chestplate");
    public static final Item HOGLIN_LEGGINGS = register(
            new HoglinArmorItem(ModArmorMaterials.HOGLIN, ArmorItem.Type.LEGGINGS, armorProps(ArmorItem.Type.LEGGINGS, 14)), "hoglin_leggings");
    public static final Item HOGLIN_BOOTS = register(
            new HoglinArmorItem(ModArmorMaterials.HOGLIN, ArmorItem.Type.BOOTS, armorProps(ArmorItem.Type.BOOTS, 14)), "hoglin_boots");

    public static final Item GOAT_FUR_HELMET = register(
            new GoatArmorItem(ModArmorMaterials.GOAT_FUR, ArmorItem.Type.HELMET, armorProps(ArmorItem.Type.HELMET, 10)), "goat_fur_helmet");
    public static final Item GOAT_FUR_CHESTPLATE = register(
            new GoatArmorItem(ModArmorMaterials.GOAT_FUR, ArmorItem.Type.CHESTPLATE, armorProps(ArmorItem.Type.CHESTPLATE, 10)), "goat_fur_chestplate");
    public static final Item GOAT_FUR_LEGGINGS = register(
            new GoatArmorItem(ModArmorMaterials.GOAT_FUR, ArmorItem.Type.LEGGINGS, armorProps(ArmorItem.Type.LEGGINGS, 10)), "goat_fur_leggings");
    public static final Item GOAT_FUR_BOOTS = register(
            new GoatArmorItem(ModArmorMaterials.GOAT_FUR, ArmorItem.Type.BOOTS, armorProps(ArmorItem.Type.BOOTS, 10)), "goat_fur_boots");

    public static final Item CHAMELEON_HELMET = register(
            new ChameleonArmorItem(ModArmorMaterials.CHAMELEON, ArmorItem.Type.HELMET, armorProps(ArmorItem.Type.HELMET, 12)), "chameleon_helmet");
    public static final Item CHAMELEON_CHESTPLATE = register(
            new ChameleonArmorItem(ModArmorMaterials.CHAMELEON, ArmorItem.Type.CHESTPLATE, armorProps(ArmorItem.Type.CHESTPLATE, 12)), "chameleon_chestplate");
    public static final Item CHAMELEON_LEGGINGS = register(
            new ChameleonArmorItem(ModArmorMaterials.CHAMELEON, ArmorItem.Type.LEGGINGS, armorProps(ArmorItem.Type.LEGGINGS, 12)), "chameleon_leggings");
    public static final Item CHAMELEON_BOOTS = register(
            new ChameleonArmorItem(ModArmorMaterials.CHAMELEON, ArmorItem.Type.BOOTS, armorProps(ArmorItem.Type.BOOTS, 12)), "chameleon_boots");

    // Block Items
    public static final BlockItem BOILER = register(
            new BlockItem(ModBlocks.BOILER, BoilerBlock.getItemProperties()), "boiler");
    public static final BlockItem ICEBOX = register(
            new BlockItem(ModBlocks.ICEBOX, IceboxBlock.getItemProperties()), "icebox");
    public static final BlockItem SEWING_TABLE = register(
            new BlockItem(ModBlocks.SEWING_TABLE, SewingTableBlock.getItemProperties()), "sewing_table");
    public static final BlockItem HEARTH = register(
            new BlockItem(ModBlocks.HEARTH_BOTTOM, HearthBottomBlock.getItemProperties()), "hearth");
    public static final BlockItem THERMOLITH = register(
            new BlockItem(ModBlocks.THERMOLITH, ThermolithBlock.getItemProperties()), "thermolith");
    public static final BlockItem SOUL_SPROUT = register(
            new SoulSproutItem(ModBlocks.SOUL_STALK,
                    SoulStalkBlock.getItemProperties().food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationModifier(0.5f)
                            .alwaysEdible()
                            .fast()
                            .build())),
            "soul_sprout");
    public static final BlockItem SMOKESTACK = register(
            new BlockItem(ModBlocks.SMOKESTACK, SmokestackBlock.getItemProperties()), "smokestack");

    // Spawn Eggs
    public static final SpawnEggItem CHAMELEON_SPAWN_EGG = register(
            new SpawnEggItem(ModEntities.CHAMELEON, 0x82C841, 0x1C9170, new Item.Properties()),
            "chameleon_spawn_egg");

    public static <T extends Item> T register(T item, String id) {
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(ColdSweat.MOD_ID, id);
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }

    private static Item.Properties armorProps(ArmorItem.Type type, int multiplier) {
        return new Item.Properties().durability(type.getDurability(multiplier));
    }
}
