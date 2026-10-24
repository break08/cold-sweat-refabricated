package com.momosoftworks.coldsweat.core.init;

import com.momosoftworks.coldsweat.ColdSweat;
import com.momosoftworks.coldsweat.common.block.*;
import com.momosoftworks.coldsweat.common.fluid.SlushFluid;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks
{
    public static final Block CONDENSED_DIRT = register(
            new Block(BlockBehaviour.Properties.of().sound(SoundType.GRASS)),
            "condensed_dirt",
            true
    );

    public static final Block BOILER = register(
            new BoilerBlock(BoilerBlock.getProperties()),
            "boiler",
            true
    );

    public static final Block ICEBOX = register(
            new IceboxBlock(IceboxBlock.getProperties()),
            "icebox",
            true
    );

    public static final Block SEWING_TABLE = register(
            new SewingTableBlock(SewingTableBlock.getProperties()),
            "sewing_table",
            true
    );

    public static final Block MINECART_INSULATION = register(
            new MinecartInsulationBlock(MinecartInsulationBlock.getProperties()),
            "minecart_insulation",
            true
    );

    public static final Block HEARTH_BOTTOM = register(
            new HearthBottomBlock(HearthBottomBlock.getProperties()),
            "hearth_bottom",
            true
    );

    public static final Block HEARTH_TOP = register(
            new HearthTopBlock(HearthTopBlock.getProperties()),
            "hearth_top",
            true
    );

    public static final Block THERMOLITH = register(
            new ThermolithBlock(ThermolithBlock.getProperties()),
            "thermolith",
            true
    );

    public static final Block SOUL_STALK = register(
            new SoulStalkBlock(SoulStalkBlock.getProperties()),
            "soul_stalk",
            true
    );

    public static final Block SMOKESTACK = register(
            new SmokestackBlock(SmokestackBlock.getProperties()),
            "smokestack",
            true
    );

    public static final LiquidBlock SLUSH = register(
            new SlushLiquidBlock(ModFluids.SLUSH, SlushFluid.getBlockProperties()),
            "slush",
            true
    );


    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(ColdSweat.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {}
}