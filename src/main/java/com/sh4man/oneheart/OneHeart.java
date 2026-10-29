package com.sh4man.oneheart;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod(modid = OneHeart.MODID, name = OneHeart.NAME, version = OneHeart.VERSION)
public class OneHeart
{
    public static final String MODID = "oneheart";
    public static final String NAME = "OneHeart";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setHearts(EntityPlayer player)
    {
        if (player != null && !player.world.isRemote)
        {
            player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2.0F);
            player.setHealth(2.0F);
        }
    }

    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent event)
    {
        setHearts(event.player);
    }

    @SubscribeEvent
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event)
    {
        setHearts(event.player);
    }
}
