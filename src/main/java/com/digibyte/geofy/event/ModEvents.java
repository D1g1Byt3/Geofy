package com.digibyte.geofy.event;

import com.digibyte.geofy.GeofyMod;
import com.digibyte.geofy.command.ReturnHomeCommand;
import com.digibyte.geofy.command.SetHomeCommand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = GeofyMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getLevel().isClientSide()) {
            event.getPlayer().getPersistentData().putIntArray(GeofyMod.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(GeofyMod.MOD_ID + "homepos"));
        }
    }

    /*
    @SubscribeEvent
    public static void setEntityOnFireWhenHit(LivingDamageEvent event){
        if(!event.getEntity().level.isClientSide()) {
            Player player = (Player) event.getSource().getDirectEntity();
            if (player == null) {
            if (player.getMainHandItem().getItem() == Items.NETHER_BRICK) {
                player.getMainHandItem().shrink(1);
                event.getEntityLiving().setSecondsOnFire(2);
            }
        }
        }
    }


     */

}
