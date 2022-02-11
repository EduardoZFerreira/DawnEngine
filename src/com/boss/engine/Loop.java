package com.boss.engine;

import com.boss.enums.engine.GameStatus;

public class Loop {
    protected final Double frameRate = 60.00;

    private Game game;
    private Thread thread;

    Long clock = System.nanoTime();
    double ns = 1000000000 / frameRate;
    double delta = 0;

    public void run() {
        game = Game.getInstance();
        game.status = GameStatus.RUNNING;
        thread = new Thread(this::loop);
        thread.start();
    }

    public void stop() {
        try {
            game.status = GameStatus.STOPPED;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected Boolean processInput() {
        Long currentClock = System.nanoTime();
        delta += (currentClock - clock) / ns;
        clock = currentClock;
        return delta >= 1;
    }

    protected void loop() {
        while (game.isGameRunning()) {
            if (processInput()) {
                game.render();
                game.tick();
                delta --;
            }
        }
        stop();
    }
}
