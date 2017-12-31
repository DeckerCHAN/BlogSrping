package com.deckerchan.blog.game.entites.Ships;

import com.deckerchan.blog.game.entites.Ship;
import com.deckerchan.blog.game.entites.basic.Point;
import javafx.geometry.Point2D;

import java.util.List;

public class Yamato extends Ship {

    public Yamato(Point coordinate, double direction, List<Point> shape) {
        super(coordinate, direction, shape);
    }
}
