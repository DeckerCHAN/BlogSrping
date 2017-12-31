package com.deckerchan.blog.game.entites;

import com.deckerchan.blog.game.entites.basic.Point;
import javafx.scene.shape.Polygon;

import java.util.List;

public abstract class Ship extends SolidObject {


    public Ship(Point coordinate, double direction, List<Point> shape) {
        super(coordinate, direction, shape);
    }
}
