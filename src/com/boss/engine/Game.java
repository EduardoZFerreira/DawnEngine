package com.boss.engine;

import com.boss.enums.engine.GameStatus;
import com.boss.graphics.Spritesheet;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    private static Game single_instance = null;
    private final BufferedImage image;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected final Loop loop = new Loop();
    protected GameStatus status = GameStatus.STOPPED;

    public static JFrame frame;

    public static final int WIDTH = 240;
    public static final int HEIGHT = 160;
    public static final int SCALE = 3;

    public Spritesheet spritesheet;

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.run();
    }

    public static Game getInstance()
    {
        if (single_instance == null)
            single_instance = new Game();

        return single_instance;
    }

    public void run() {
        loop.run();
    }

    public void initFrame() {
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        frame = new JFrame("Project DAWN");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = image.getGraphics();

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        bs.show();
    }

    public void tick() {

    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }

    private void load() {
        spritesheet = new Spritesheet("/spritesheets/spritesheet.png");
    }

    private Game() {
        requestFocus();
        initFrame();
        load();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Controls controls = new Controls();
        addKeyListener(controls);
        addMouseListener(controls);
    }
}
