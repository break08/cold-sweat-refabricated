package com.momosoftworks.coldsweat.core.init;

import com.momosoftworks.coldsweat.ColdSweat;
import com.momosoftworks.coldsweat.data.tag.ModItemTags;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials
{
    public static final Holder<ArmorMaterial> ARMOR_MATERIALS = registerMaterial("hoglin",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 6,
                    ArmorItem.Type.LEGGINGS, 5,
                    ArmorItem.Type.BOOTS, 2
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            25,
            // The sound played when the armor is equipped.
            SoundEvents.ARMOR_EQUIP_LEATHER,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.of(ModItemTags.HOGLIN_LEATHERS),
            1.5F,
            0.0F,

            false
    );

    public static final Holder<ArmorMaterial> GOAT_FUR = registerMaterial("goat_fur",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 5,
                    ArmorItem.Type.LEGGINGS, 4,
                    ArmorItem.Type.BOOTS, 1
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            15,
            // The sound played when the armor is equipped.
            SoundEvents.ARMOR_EQUIP_LEATHER,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.of(ModItemTags.GOAT_FURS),
            0.0F, 0.0F,

            false
    );

    public static final Holder<ArmorMaterial> CHAMELEON = registerMaterial("chameleon",
            // Defense (protection) point values for each armor piece.
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 6,
                    ArmorItem.Type.LEGGINGS, 5,
                    ArmorItem.Type.BOOTS, 2
            ),
            // Enchantability. For reference, leather has 15, iron has 9, and diamond has 10.
            15,
            // The sound played when the armor is equipped.
            ModSounds.ARMOR_EQUIP_CHAMELEON,
            // The ingredient(s) used to repair the armor.
            () -> Ingredient.of(ModItemTags.CHAMELEON_SCALES),
            0.0F, 0.0F,

            false
    );

    public static Holder<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        // Get the supported layers for the armor material
        List<ArmorMaterial.Layer> layers = List.of(
                // The ID of the texture layer, the suffix, and whether the layer is dyeable.
                // We can just pass the armor material ID as the texture layer ID.
                // We have no need for a suffix, so we'll pass an empty string.
                // We'll pass the dyeable boolean we received as the dyeable parameter.
                new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(ColdSweat.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);
        // Register the material within the ArmorMaterials registry.
        material = Registry.register(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.fromNamespaceAndPath(ColdSweat.MOD_ID, id), material);

        // The majority of the time, you'll want the RegistryEntry of the material - especially for the ArmorItem constructor.
        return Holder.direct(material);
    }

    public static void initialize() {};
}