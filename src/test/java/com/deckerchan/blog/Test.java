package com.deckerchan.blog;


import com.deckerchan.blog.game.Game;
import com.deckerchan.blog.game.entites.SolidObject;
import com.deckerchan.blog.game.entites.basic.Line;
import com.deckerchan.blog.game.entites.basic.Point;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static java.lang.System.out;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @org.junit.Test
    public void test1() throws Exception {
        Line a = new Line(new Point(1, 1), new Point(10, 1));
        Line b = new Line(new Point(1, 2), new Point(10, 2));

        assert (!a.intersect(b));
    }

    @org.junit.Test
    public void test2() throws Exception {
        Line a = new Line(new Point(10, 0), new Point(0, 10));
        Line b = new Line(new Point(0, 0), new Point(10, 10));

        assert (a.intersect(b));
    }

    @org.junit.Test
    public void test3() throws Exception {
        ArrayList<Point> shape = new ArrayList<>();
        shape.add(new Point(10, -5));
        shape.add(new Point(-10, -5));
        shape.add(new Point(-10, 5));
        shape.add(new Point(10, 5));


        SolidObject a = new SolidObject(new Point(50, 50), 0, shape);

        SolidObject b = new SolidObject(new Point(50, 70), 0, shape);

        for (int i = 0; i < 10000; i++) {
            b.moveAlongY(-0.01);

            if (a.intersect(b)) {
                out.println(b.getCoordinate());

            }
        }

        assert !a.intersect(b);

    }

    @org.junit.Test
    public void gameThreadTest() throws Exception {
        Game game = new Game();

        game.start();
    }


}
