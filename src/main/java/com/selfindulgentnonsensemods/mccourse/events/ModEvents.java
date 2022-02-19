package com.selfindulgentnonsensemods.mccourse.events;

import com.selfindulgentnonsensemods.mccourse.item.ModItems;
import com.selfindulgentnonsensemods.mccourse.util.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class ModEvents {

    @SubscribeEvent
    public void onPizzadMob(AttackEntityEvent event) {
        if (event.getPlayer().getHeldItemMainhand().getItem() == ModItems.SLICE_OF_PIZZA.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof MobEntity)  // target instanceof SheepEntity
                {
                    PlayerEntity player = event.getPlayer();
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.SPEED, Config.PIZZAD_SPEED_DURATION.get()));

                    if (!player.world.isRemote()) {
                        String msg = TextFormatting.YELLOW + "Some guy just fed pizza to a non human. That is probably not healthy.";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }

    }

    @SubscribeEvent
    public void onFloatingMob(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity instanceof SheepEntity) {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();
            LogManager.getLogger().debug(entity.getActivePotionEffects());
            if (entity.isPotionActive(Effects.GLOWING)) {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.SLICE_OF_PIZZA.get())));
            }
        }
    }

}