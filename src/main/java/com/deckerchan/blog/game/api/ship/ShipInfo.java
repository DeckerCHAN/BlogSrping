package com.deckerchan.blog.game.api.ship;

import com.deckerchan.blog.game.api.turret.TurretInfo;

import java.util.List;

public interface ShipInfo {
    public double getSpeed();
    public double getDirection();
    public double getFullHp();
    public double getCurrentHp();
    public ShipControl getControl();
    public List<TurretInfo> getTurrets();

}
