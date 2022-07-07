package com.division.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Set;

public class EntitySteerEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    private final Set<Direction> directions;
    private final Player player;
    private final Entity entity;

    public EntitySteerEvent(Player player, Entity entity, Set<Direction> directions) {
        this.directions = directions;
        this.player = player;
        this.entity = entity;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public boolean isForward() {
        return contains(Direction.UP);
    }

    public boolean isBackWard() {
        return contains(Direction.DOWN);
    }

    public boolean isRight() {
        return contains(Direction.RIGHT);
    }

    public boolean isLeft() {
        return contains(Direction.LEFT);
    }

    public boolean isJump() {
        return contains(Direction.JUMP);
    }

    public boolean isUnmount() {
        return contains(Direction.UNMOUNT);
    }

    public Player getWhoSteer() {
        return player;
    }

    public Entity getEntity() {
        return entity;
    }

    private boolean contains(Direction value) {
        return directions.contains(value);
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT,
        JUMP,
        UNMOUNT
    }
}
