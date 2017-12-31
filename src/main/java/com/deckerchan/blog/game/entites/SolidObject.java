package com.deckerchan.blog.game.entites;

import com.deckerchan.blog.game.entites.basic.Line;
import com.deckerchan.blog.game.entites.basic.Point;

import java.util.*;
import java.util.stream.Collectors;

public class SolidObject {
    private Point coordinate;
    private double direction;

    private List<Point> shape;
    private double maxiumOutbond;

    public SolidObject(Point coordinate, double direction, List<Point> shape) {
        this.coordinate = coordinate;
        this.direction = direction;
        if (shape.size() < 3) {
            throw new IllegalArgumentException("Number of key points can not below 3!");
        }
        this.shape = shape;
        this.maxiumOutbond = this.shape.stream().map(x -> Math.sqrt(Math.pow(x.getX(), 2) + Math.pow(x.getY(), 2))).max(Comparator.naturalOrder()).get();
    }

    public Collection<Line> getLines() {
        List<Point> points = this.getActualPoints();
        Set<Line> res = new HashSet<>();
        for (int index = 0; index < points.size() - 1; index++) {
            Line line = new Line(points.get(index), points.get(index + 1));
            res.add(line);
        }

        return res;
    }

    public List<Point> getActualPoints() {
        return this.shape.stream().map(x -> x.rotate(Point.ZERO, this.direction)).map(x -> x.offset(this.coordinate)).collect(Collectors.toList());
    }

    public Point getCoordinate() {
        return coordinate;
    }


    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public List<Point> getShape() {
        return shape;
    }

    public void setShape(List<Point> shape) {
        this.shape = shape;
    }

    public void moveAlongX(double distance) {
        this.coordinate = new Point(this.coordinate.getX() + distance, this.coordinate.getY());
    }

    public void moveAlongY(double distance) {
        this.coordinate = new Point(this.coordinate.getX(), this.coordinate.getY() + distance);
    }

    public void moveAlongXY(double distanceX, double distanceY) {
        this.coordinate = new Point(this.coordinate.getX() + distanceX, this.coordinate.getY() + distanceY);
    }


    public double getMaximOutbound() {
        return maxiumOutbond;
    }


    public boolean intersect(SolidObject object) {

        if (this.coordinate.distance(object.coordinate) > (this.maxiumOutbond + object.getMaximOutbound())) {
            return false;
        }

        for (Line original : this.getLines()) {
            for (Line against : object.getLines()) {
                if (original.intersect(against)) {
                    return true;
                }
            }
        }

        return false;
    }
}
