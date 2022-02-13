package com.boss.engine;

import com.boss.entities.Player;
import com.boss.enums.engine.GameStatus;
import com.boss.graphics.Spritesheet;
import com.boss.world.World;
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
    public GameStatus status = GameStatus.STOPPED;

    public static JFrame frame;

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int SCALE = 1;

    public Spritesheet spritesheet;
    public Player player;
    public World world;

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.run();
    }

    public static synchronized Game getInstance()
    {
        if (single_instance == null)
            single_instance = new Game();
        return single_instance;
    }

    public void run() {
        initFrame();
        load();
        Controls controls = new Controls();
        addKeyListener(controls);
        addMouseListener(controls);
        requestFocus();
        loop.run();
    }

    public void initFrame() {
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        frame = new JFrame("DAWN Engine");
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        //frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = image.getGraphics();

        world.render(g);
        player.render(g);

        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

        bs.show();
    }

    public void tick() {
        Camera.followTarget(player);
        player.tick();
    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }

    private void load() {
        spritesheet = new Spritesheet("/spritesheets/spritesheet.png");
        player = new Player(0, 0, World.TILE_SIZE, World.TILE_SIZE, spritesheet.getSprite(2 * World.TILE_SIZE, 0, World.TILE_SIZE, World.TILE_SIZE));
        world = new World("/maps/testStage/testStage.png");
    }

    private Game() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }
}
