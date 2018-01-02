package com.deckerchan.blog.game.entites.Ships;

import com.deckerchan.blog.game.api.ship.ShipControl;
import com.deckerchan.blog.game.api.turret.TurretInfo;
import com.deckerchan.blog.game.entites.Ship;
import com.deckerchan.blog.game.entites.basic.Point;

import java.util.List;

public class Yamato extends Ship {

    public Yamato(Point coordinate, double direction, List<Point> shape) {
        super(coordinate, direction, shape);
    }

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public double getFullHp() {
        return 0;
    }

    @Override
    public double getCurrentHp() {
        return 0;
    }

    @Override
    public ShipControl getControl() {
        return null;
    }

    @Override
    public List<TurretInfo> getTurrets() {
        return null;
    }
}
