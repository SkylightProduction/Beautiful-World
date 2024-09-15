package com.skylightmodding.init;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.items.*;
import com.skylightmodding.items.types.*;
import com.skylightmodding.items.components.BWFoodComponents;
import com.skylightmodding.items.components.ToolModifications;
import com.skylightmodding.items.components.BWArmorMaterial;
import com.skylightmodding.items.components.BWToolMaterials;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class BWItems {
    // Ore
    public static final Item CRYSTALLITE = registerItem(
            "crystallite",
            new Item(new Item.Settings())
    );
    public static final Item OVERLOUD_INGOT = registerItem(
            "overloud_ingot",
            new Item(new Item.Settings())
    );
    public static final Item RAW_OVERLOUD = registerItem(
            "raw_overloud",
            new Item(new Item.Settings())
    );
    public static final Item RHODIUM_INGOT = registerItem(
            "rhodium_ingot",
            new Item(new Item.Settings().fireproof())
    );

    // Korg Items
    public static final Item KORG_FRAGMENT = registerItem(
            "korg_fragment",
            new Item(new Item.Settings().rarity(Rarity.EPIC))
    );

    // overloud items
    public static final Item OVERLOUD_HELMET = registerItem(
            "overloud_helmet",
            new ArmorItem(BWArmorMaterial.OVERLOUD, ArmorItem.Type.HELMET, new Item.Settings())
    );
    public static final Item OVERLOUD_CHESTPLATE = registerItem(
            "overloud_chestplate",
            new ArmorItem(BWArmorMaterial.OVERLOUD, ArmorItem.Type.CHESTPLATE, new Item.Settings())
    );
    public static final Item OVERLOUD_LEGGINGS = registerItem(
            "overloud_leggings",
            new ArmorItem(BWArmorMaterial.OVERLOUD, ArmorItem.Type.LEGGINGS, new Item.Settings())
    );
    public static final Item OVERLOUD_BOOTS = registerItem(
            "overloud_boots",
            new ArmorItem(BWArmorMaterial.OVERLOUD, ArmorItem.Type.BOOTS, new Item.Settings())
    );
    public static final Item OVERLOUD_SWORD = registerItem(
            "overloud_sword",
            new SwordItem(BWToolMaterials.OVERLOUD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BWToolMaterials.OVERLOUD, 10, -2.4F)))
    );
    public static final Item OVERLOUD_PICKAXE = registerItem(
            "overloud_pickaxe",
            new PickaxeItem(BWToolMaterials.OVERLOUD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(BWToolMaterials.OVERLOUD, 7, -2.8F)))
    );
    public static final Item OVERLOUD_AXE = registerItem(
            "overloud_axe",
            new AxeItem(BWToolMaterials.OVERLOUD, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(BWToolMaterials.OVERLOUD, 13, -3.2F)))
    );
    public static final Item OVERLOUD_HOE = registerItem(
            "overloud_hoe",
            new HoeItem(BWToolMaterials.OVERLOUD, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(BWToolMaterials.OVERLOUD, 1, -1.0F)))
    );
    public static final Item OVERLOUD_SHOVEL = registerItem(
            "overloud_shovel",
            new ShovelItem(BWToolMaterials.OVERLOUD, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(BWToolMaterials.OVERLOUD, 3.5f, -2.0F)))
    );
    public static final Item OVERLOUD_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "overloud_upgrade_smithing_template",
            BWSmithingTemplateItem.createOverloudUpgrade()
    );

    // rhodium
    public static final Item RHODIUM_SWORD = registerItem(
        "rhodium_sword",
        new SwordItem(BWToolMaterials.RHODIUM, new Item.Settings().rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(BWToolMaterials.RHODIUM, 5, -2.4F))) {
            @Override
            public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                super.postHit(stack, target, attacker);
                ToolModifications.torchTheEnemy((byte)6, target);

                return true;
            }
        }
    );
    public static final Item RHODIUM_MULTITOOL = registerItem(
            "rhodium_multitool",
            new FieryMultiTool(BWToolMaterials.RHODIUM, new Item.Settings().rarity(Rarity.RARE).component(BWDataComponents.IS_FIERY, true).attributeModifiers(MultiToolItem.createAttributeModifiers(BWToolMaterials.RHODIUM, 2.5f, -2.8F)))
    );

    // crytallite
    public static final Item CRYSTALLITE_PICKAXE = registerItem(
            "crystallite_pickaxe",
            new CrystallitePickaxeItem(BWToolMaterials.CRYSTALLITE, BlockTags.PICKAXE_MINEABLE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(BWToolMaterials.CRYSTALLITE, 2.5f, -2.8F)))
    );
    public static final Item CRYSTALLITE_SHOVEL = registerItem(
            "crystallite_shovel",
            new CrystalliteShovelItem(BWToolMaterials.CRYSTALLITE, BlockTags.SHOVEL_MINEABLE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(BWToolMaterials.CRYSTALLITE, 0.5f, -2.0F)))
    );
    public static final Item CRYSTALLITE_AXE = registerItem(
            "crystallite_axe",
            new CrystalliteAxeItem(BWToolMaterials.CRYSTALLITE, BlockTags.AXE_MINEABLE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(BWToolMaterials.CRYSTALLITE, 3.0f, -3.2F)))
    );

    // other
    public static final Item NETHERITE_MULTI_TOOL = registerItem(
            "netherite_multitool",
            new MultiToolItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(MultiToolItem.createAttributeModifiers(ToolMaterials.NETHERITE, -1.5f, -2.8F)))
    );
    public static final Item PITAHAYA = registerItem(
            "pitahaya",
            new Item(new Item.Settings().food(BWFoodComponents.PITAHAYA)));
    public static final Item BAIKAL_WATER = registerItem(
            "baikal_water",
            new BaikalWaterItem(new Item.Settings())
    );
    public static final Item AMULET_OF_CREATION = registerItem(
            "amulet_of_creation",
            new AmuletOfCreation(new Item.Settings().maxCount(1).rarity(Rarity.EPIC))
    );



    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BeautifulWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BeautifulWorld.LOGGER.info("Registering Items from " + BeautifulWorld.MOD_ID);
    }
}
