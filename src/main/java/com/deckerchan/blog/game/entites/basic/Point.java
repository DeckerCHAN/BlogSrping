package com.deckerchan.blog.game.entites.basic;

public class Point {
    public static final Point ZERO = new Point(0, 0);
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%f,%f", this.getX(), this.getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(Math.abs(point.getX() - this.getX()), 2) + Math.pow(Math.abs(point.getY() - this.getY()), 2));
    }

    public Point offset(Point coordinate) {
        return new Point(this.getX() + coordinate.getX(), this.getY() + coordinate.getY());
    }

    public Point rotate(Point center, double angle) {


        double s = Math.sin(Math.toRadians(angle));
        double c = Math.cos(Math.toRadians(angle));

        Double px = this.getX() - center.getX();
        Double py = this.getY() - center.getY();

        // rotate point
        double xnew = px * c - py * s;
        double ynew = px * s + py * c;

        // translate point back:
        px = xnew + center.getX();
        py = ynew + center.getY();

        return new Point(px, py);

    }


}
