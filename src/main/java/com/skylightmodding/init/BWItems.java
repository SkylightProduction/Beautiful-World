package com.skylightmodding.init;

import com.skylightmodding.BeautifulWorld;
import com.skylightmodding.items.AmuletOfCreation;
import com.skylightmodding.items.BaikalWaterItem;
import com.skylightmodding.items.type.MultiToolItem;

import com.skylightmodding.misc.BWArmorMaterial;
import com.skylightmodding.misc.BWToolMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipType;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

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
        new PickaxeItem(BWToolMaterials.OVERLOUD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(BWToolMaterials.OVERLOUD, 7, -2.8F))) {
            @Override public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
                super.postMine(stack, world, state, pos, miner);

//                new RecipeManager.load();

                Block broken_block = state.getBlock();
                broken_block.asItem();

                return true;
            }
        }
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

    // rhodium
    public static final Item RHODIUM_SWORD = registerItem(
        "rhodium_sword",
        new SwordItem(BWToolMaterials.RHODIUM, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(BWToolMaterials.RHODIUM, 5, -2.4F))) {
            @Override
            public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                if (!target.isFireImmune()) { target.setOnFireFor(5); }
                stack.damage(1, attacker, EquipmentSlot.MAINHAND);

                return true;
            }
        }
    );
    public static final Item RHODIUM_MULTITOOL = registerItem(
            "rhodium_multitool",
            new MultiToolItem(BWToolMaterials.RHODIUM, new Item.Settings().attributeModifiers(MultiToolItem.createAttributeModifiers(BWToolMaterials.RHODIUM, 2.5f, -2.8F)))
    );

    // other
    public static final Item NETHERITE_MULTI_TOOL = registerItem(
            "netherite_multitool",
            new MultiToolItem(ToolMaterials.NETHERITE, new Item.Settings().attributeModifiers(MultiToolItem.createAttributeModifiers(ToolMaterials.NETHERITE, -1.5f, -2.8F)))
    );
    public static final Item PITAHAYA = registerItem(
        "pitahaya",
        new Item(new Item.Settings().food(new FoodComponent(5, 4.5f, true, 1.6f, List.of()))) {
            @Override
            public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
                user.addStatusEffect(new StatusEffectInstance(BWStatusEffects.IMMUNITY, 2400, 0));
                if (user.hasStatusEffect(BWStatusEffects.INFECTION)) { user.removeStatusEffect(BWStatusEffects.INFECTION); }

                return super.finishUsing(stack, world, user);
            }
        }
    );
    public static final Item BAIKAL_WATER = registerItem(
        "baikal_water",
        new BaikalWaterItem(new Item.Settings()) {
            @Override
            public void appendTooltip(ItemStack itemStack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                tooltip.add(Text.translatable("tooltip.beautifulworld.baikal_water").formatted(Formatting.GRAY));
            }
        }
    );
    public static final Item AMULET_OF_CREATION = registerItem(
            "amulet_of_creation",
            new AmuletOfCreation(new Item.Settings())
    );



    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BeautifulWorld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BeautifulWorld.LOGGER.info("Registering Items from " + BeautifulWorld.MOD_ID);
    }
}
