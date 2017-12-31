package com.deckerchan.blog.game.entites.basic;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int orientation(Point p, Point q, Point r)
    {
        // See https://www.geeksforgeeks.org/orientation-3-ordered-points/
        // for details of below formula.
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) -
                (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0) return 0;  // colinear

        return (val > 0)? 1: 2; // clock or counterclock wise
    }
    public boolean onSegment(Point p, Point q, Point r)
    {
        return q.getX() <= Math.max(p.getX(), r.getX()) && q.getX() >= Math.min(p.getX(), r.getX()) &&
                q.getY() <= Math.max(p.getY(), r.getY()) && q.getY() >= Math.min(p.getY(), r.getY());

    }


    public boolean intersect(Line line)
    {
        // Find the four orientations needed for general and
        // special cases
        int o1 = orientation(this.getStart(), this.getEnd(), line.getStart());
        int o2 = orientation(this.getStart(), this.getEnd(), line.getEnd());
        int o3 = orientation(line.getStart(), line.getEnd(), this.getStart());
        int o4 = orientation(line.getStart(), line.getEnd(), this.getEnd());

        // General case
        if (o1 != o2 && o3 != o4)
            return true;

        // Special Cases
        // this.getStart(), this.getEnd() and line.getStart() are colinear and line.getStart() lies on segment this.getStart()this.getEnd()
        if (o1 == 0 && onSegment(this.getStart(), line.getStart(), this.getEnd())) return true;

        // this.getStart(), this.getEnd() and line.getStart() are colinear and line.getEnd() lies on segment this.getStart()this.getEnd()
        if (o2 == 0 && onSegment(this.getStart(), line.getEnd(), this.getEnd())) return true;

        // line.getStart(), line.getEnd() and this.getStart() are colinear and this.getStart() lies on segment line.getStart()line.getEnd()
        if (o3 == 0 && onSegment(line.getStart(), this.getStart(), line.getEnd())) return true;

        // line.getStart(), line.getEnd() and this.getEnd() are colinear and this.getEnd() lies on segment line.getStart()line.getEnd()
        if (o4 == 0 && onSegment(line.getStart(), this.getEnd(), line.getEnd())) return true;

        return false; // Doesn't fall in any of the above cases
    }
}
