package com.deckerchan.blog.game;

import com.deckerchan.blog.game.entites.Map;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Game {
    private final long interval = 1000;
    private boolean running = false;
    private Map map;
    private Thread god;
    private long nextGodTick = 0;
    private Thread player1;
    private Thread player2;

    public Game() {

        this.god = new Thread(() -> {
            while (this.running) {
                try {
                    if (this.nextGodTick == 0) {
                        this.nextGodTick = System.currentTimeMillis() + this.interval;
                    } else {

                        Thread.sleep(this.nextGodTick - System.currentTimeMillis());
                        this.nextGodTick = System.currentTimeMillis() + this.interval;
                    }

                    // Update everything
                    System.out.println("god");
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }

        });

        this.player1 = new Thread(() -> {
            while (this.running) {
                try {
                    System.out.println("Player1");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }


        });
        this.player2 = new Thread(() -> {
            while (this.running) {
                try {
                    System.out.println("Player2");
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }

        });

    }

    public void start() throws InterruptedException {
        System.out.println("STARTED!!!!!!!");

        this.running = true;

        this.god.start();
        this.player1.start();
        this.player2.start();

        this.god.join();
        this.player1.join();
        this.player2.join();
    }

}
