package com.deckerchan.blog.game.entites;

import com.deckerchan.blog.game.api.ship.ShipInfo;
import com.deckerchan.blog.game.entites.basic.Point;

import java.util.List;

public abstract class Ship extends SolidObject implements ShipInfo {


    public Ship(Point coordinate, double direction, List<Point> shape) {
        super(coordinate, direction, shape);
    }
}
