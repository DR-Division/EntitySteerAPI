package com.division.packet;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;
import com.division.event.EntitySteerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

public class EntitySteerListener extends PacketAdapter {

    private final JavaPlugin Plugin;

    public EntitySteerListener(JavaPlugin plugin, PacketType... types) {
        super(plugin, types);
        this.Plugin = plugin;
    }

    @Override
    public void onPacketReceiving(PacketEvent event) {
        PacketType type = event.getPacketType();
        Player p = event.getPlayer();
        Entity entity = p.getVehicle();
        if (entity != null && type == PacketType.Play.Client.STEER_VEHICLE) {
            Set<EntitySteerEvent.Direction> directionSet = new HashSet<>();
            PacketContainer container = event.getPacket(); //STEER_VEHICLE
            StructureModifier<Float> floatModifier = container.getFloat(); //float field
            float wsValue = floatModifier.read(1);  //W OR S Value
            float adValue = floatModifier.read(0);  //A OR D Value
            if (wsValue > 0) //FORWARD
                directionSet.add(EntitySteerEvent.Direction.UP);
            else if (wsValue < 0)
                directionSet.add(EntitySteerEvent.Direction.DOWN);
            if (adValue > 0) //LEFT
                directionSet.add(EntitySteerEvent.Direction.LEFT);
            else if (adValue < 0)
                directionSet.add(EntitySteerEvent.Direction.RIGHT);
            Bukkit.getScheduler().runTask(Plugin, () -> Bukkit.getPluginManager().callEvent(new EntitySteerEvent(p, entity, directionSet)));
        }
    }
}
