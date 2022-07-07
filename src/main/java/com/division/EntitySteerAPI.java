package com.division;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.division.packet.EntitySteerListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EntitySteerAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        ProtocolLibrary.getProtocolManager().addPacketListener(new EntitySteerListener(this, PacketType.Play.Client.STEER_VEHICLE)); //LISTENER
    }

    @Override
    public void onDisable() {

    }
}
