package com.skylightmodding.items.type;

import com.skylightmodding.BeautifulWorld;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class BWSmithingTemplateItem extends SmithingTemplateItem {
    private static final Formatting TITLE_FORMATTING;
    private static final Formatting DESCRIPTION_FORMATTING;

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE;
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE;
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE;
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE;
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE;
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE;
    private static final Identifier EMPTY_SLOT_INGOT_TEXTURE;

    private static final Text OVERLOUD_UPGRADE_TEXT;
    private static final Text OVERLOUD_UPGRADE_APPLIES_TO_TEXT;
    private static final Text OVERLOUD_UPGRADE_INGREDIENTS_TEXT;
    private static final Text OVERLOUD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT;
    private static final Text OVERLOUD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT;

    public BWSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures, FeatureFlag... requiredFeatures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures, requiredFeatures);
    }

    public static BWSmithingTemplateItem createOverloudUpgrade() {
        return new BWSmithingTemplateItem(OVERLOUD_UPGRADE_APPLIES_TO_TEXT, OVERLOUD_UPGRADE_INGREDIENTS_TEXT, OVERLOUD_UPGRADE_TEXT, OVERLOUD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, OVERLOUD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, getOverloudUpgradeEmptyBaseSlotTextures(), getOverloudUpgradeEmptyAdditionsSlotTextures(), new FeatureFlag[0]);
    }

    private static List<Identifier> getOverloudUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getOverloudUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_INGOT_TEXTURE);
    }

    static {
        TITLE_FORMATTING = Formatting.GRAY;
        DESCRIPTION_FORMATTING = Formatting.BLUE;

        OVERLOUD_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", Identifier.of(BeautifulWorld.MOD_ID, "overloud_upgrade"))).formatted(TITLE_FORMATTING);
        OVERLOUD_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(BeautifulWorld.MOD_ID, "smithing_template.overloud_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
        OVERLOUD_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(BeautifulWorld.MOD_ID, "smithing_template.overloud_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
        OVERLOUD_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(BeautifulWorld.MOD_ID, "smithing_template.overloud_upgrade.base_slot_description")));
        OVERLOUD_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", Identifier.of(BeautifulWorld.MOD_ID, "smithing_template.overloud_upgrade.additions_slot_description")));

        EMPTY_ARMOR_SLOT_HELMET_TEXTURE = Identifier.of("item/empty_armor_slot_helmet");
        EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = Identifier.of("item/empty_armor_slot_chestplate");
        EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = Identifier.of("item/empty_armor_slot_leggings");
        EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = Identifier.of("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE_TEXTURE = Identifier.of("item/empty_slot_hoe");
        EMPTY_SLOT_AXE_TEXTURE = Identifier.of("item/empty_slot_axe");
        EMPTY_SLOT_SWORD_TEXTURE = Identifier.of("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL_TEXTURE = Identifier.of("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE_TEXTURE = Identifier.of("item/empty_slot_pickaxe");
        EMPTY_SLOT_INGOT_TEXTURE = Identifier.of("item/empty_slot_ingot");
    }
}
