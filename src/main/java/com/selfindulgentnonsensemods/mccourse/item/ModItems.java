package com.selfindulgentnonsensemods.mccourse.item;

import com.selfindulgentnonsensemods.mccourse.MCCourseMod;
import com.selfindulgentnonsensemods.mccourse.block.ModBlocks;
import com.selfindulgentnonsensemods.mccourse.block.ModFluids;
import com.selfindulgentnonsensemods.mccourse.block.TomatoCrop;
import com.selfindulgentnonsensemods.mccourse.util.Registration;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.items.ItemStackHandler;

public class ModItems {

     // Blocks

     public static final RegistryObject<Item> YOURMOM_INGOT =
             Registration.ITEMS.register("yourmom_ingot",
                     () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     public static final RegistryObject<Item> RAW_YOURMOM =
             Registration.ITEMS.register("raw_yourmom",
                     () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     // Miscellaneous

     public static final RegistryObject<Item> TOTEM_OF_NOTHINGNESS =
             Registration.ITEMS.register("totem_of_nothingness",
                     () -> new Item(new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     // Food

     public static final RegistryObject<Item> SLICE_OF_PIZZA =
             Registration.ITEMS.register("slice_of_pizza",
                     () -> new Slice_of_pizza());

     public static final RegistryObject<Item> TOMATO =
             Registration.ITEMS.register("tomato",
                     () -> new tomato());

     public static final RegistryObject<Item> TOMATO_SOUP =
             Registration.ITEMS.register("tomato_soup",
                     () -> new tomato_soup());

     // Tools

     public static final RegistryObject<Item> YOURMOM_SHOVEL =
             Registration.ITEMS.register("yourmom_shovel",
                     () -> new ShovelItem(ModItemTier.YOURMOM, 1f, 1f,   // attackDamage , attackSpeed
                             new Item.Properties()
                                     .defaultMaxDamage(150).addToolType(ToolType.SHOVEL, 2).group(MCCourseMod.COURSE_TAB)));    // tool level (leave at 2)

     public static final RegistryObject<Item> YOURMOM_SWORD =
             Registration.ITEMS.register("yourmom_sword",
                     () -> new SwordItem(ModItemTier.YOURMOM, 6, 1f,
                             new Item.Properties()
                                     .defaultMaxDamage(150).group(MCCourseMod.COURSE_TAB)));

     public static final RegistryObject<Item> YOURMOM_PICKAXE =
             Registration.ITEMS.register("yourmom_pickaxe",
                     () -> new PickaxeItem(ModItemTier.YOURMOM, 1, 1f,   // attackDamage , attackSpeed
                             new Item.Properties()
                                     .defaultMaxDamage(150).addToolType(ToolType.PICKAXE, 2).group(MCCourseMod.COURSE_TAB)));    // tool level (leave at 2)

     public static final RegistryObject<Item> YOURMOM_HOE =
             Registration.ITEMS.register("yourmom_hoe",
                     () -> new HoeItem(ModItemTier.YOURMOM, 1, 1f,   // attackDamage , attackSpeed
                             new Item.Properties()
                                     .defaultMaxDamage(150).addToolType(ToolType.HOE, 2).group(MCCourseMod.COURSE_TAB)));    // tool level (leave at 2)

     public static final RegistryObject<Item> YOURMOM_AXE =
             Registration.ITEMS.register("yourmom_axe",
                     () -> new AxeItem(ModItemTier.YOURMOM, 1.3f, -2f,   // attackDamage , attackSpeed
                             new Item.Properties()
                                     .defaultMaxDamage(150).addToolType(ToolType.AXE, 2).group(MCCourseMod.COURSE_TAB)));    // tool level (leave at 2)

     // Armor

     public static final RegistryObject<Item> YOURMOM_HELMET =
             Registration.ITEMS.register("yourmom_helmet",
                     () -> new ArmorItem(ModArmorMaterial.YOURMOM, EquipmentSlotType.HEAD,
                             new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     public static final RegistryObject<Item> YOURMOM_CHESTPLATE =
             Registration.ITEMS.register("yourmom_chestplate",
                     () -> new ArmorItem(ModArmorMaterial.YOURMOM, EquipmentSlotType.CHEST,
                             new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     public static final RegistryObject<Item> YOURMOM_LEGGINGS =
             Registration.ITEMS.register("yourmom_leggings",
                     () -> new ArmorItem(ModArmorMaterial.YOURMOM, EquipmentSlotType.LEGS,
                             new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     public static final RegistryObject<Item> YOURMOM_BOOTS =
             Registration.ITEMS.register("yourmom_boots",
                     () -> new ArmorItem(ModArmorMaterial.YOURMOM, EquipmentSlotType.FEET,
                             new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     public static void register() {}

     // Cropses  // I'm funny I know

     public static final RegistryObject<Item> TOMATO_SEED =
             Registration.ITEMS.register("tomato_seed",
                     () -> new BlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties().group(MCCourseMod.COURSE_TAB)));

     // Fluid Stuff

     public static final RegistryObject<Item> MUD_BUCKET =
             Registration.ITEMS.register("mud_bucket",
                     () -> new BucketItem(ModFluids.MUD_FLUID::get,
                             new Item.Properties().group(MCCourseMod.COURSE_TAB).maxStackSize(1)));

     public enum ModItemTier implements IItemTier {
          YOURMOM(2, 69, 6, 1, 25, Ingredient.fromStacks(new ItemStack(ModItems.YOURMOM_INGOT.get())));

          private final int harvestLevel;
          private final int maxUses;
          private final float efficiency;
          private final float attackDamage;
          private final int enchantability;
          private final Ingredient repairMaterial;

          ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
               this.harvestLevel = harvestLevel;
               this.maxUses = maxUses;
               this.efficiency = efficiency;
               this.attackDamage = attackDamage;
               this.enchantability = enchantability;
               this.repairMaterial = repairMaterial;
          }


          @Override
          public int getMaxUses() {
               return maxUses;
          }

          @Override
          public float getEfficiency() {
               return efficiency;
          }

          @Override
          public float getAttackDamage() {
               return attackDamage;
          }

          @Override
          public int getHarvestLevel() {
               return harvestLevel;
          }

          @Override
          public int getEnchantability() {
               return enchantability;
          }

          @Override
          public Ingredient getRepairMaterial() {
               return repairMaterial;
          }
     }

     public enum ModArmorMaterial implements IArmorMaterial {
          YOURMOM(50, new int[]{3, 6, 4, 3}, 1, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                  Ingredient.fromStacks(new ItemStack(ModItems.YOURMOM_INGOT.get())),
                  MCCourseMod.MOD_ID + ":yourmom", 0, 0.1f);
          private final int durability;
          private final int[] damageReductionAmountArray;
          private final int enchantability;
          private final SoundEvent soundEvent;
          private final Ingredient repairMaterial;
          private final String name;
          private final float toughness;
          private final float knockbackResistance;

          ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent,
                           Ingredient repairMaterial, String name, float toughness, float knockbackResistance) {
               this.durability = durability;
               this.damageReductionAmountArray = damageReductionAmountArray;
               this.enchantability = enchantability;
               this.soundEvent = soundEvent;
               this.repairMaterial = repairMaterial;
               this.name = name;
               this.toughness = toughness;
               this.knockbackResistance = knockbackResistance;
          }

          @Override
          public int getDurability(EquipmentSlotType slotIn) {
               return this.durability;
          }

          @Override
          public int getDamageReductionAmount(EquipmentSlotType slotIn) {
               return damageReductionAmountArray[slotIn.getIndex()];
          }

          @Override
          public int getEnchantability() {
               return this.enchantability;
          }

          @Override
          public SoundEvent getSoundEvent() {
               return this.soundEvent;
          }

          @Override
          public Ingredient getRepairMaterial() {
               return this.repairMaterial;
          }

          @Override
          public String getName() {
               return this.name;
          }

          @Override
          public float getToughness() {
               return this.toughness;
          }

          @Override
          public float getKnockbackResistance() {
               return this.knockbackResistance;
          }
     }
}