package com.boss.engine;

import com.boss.enums.engine.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controls implements KeyListener, MouseListener {

    private final Game game = Game.getInstance();

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(KeyCode.listRightMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveRight(true);
        } else if (KeyCode.listLeftMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveLeft(true);
        }

        if(KeyCode.listUpMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveUp(true);
        } else if (KeyCode.listDownMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(KeyCode.listRightMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveRight(false);
        } else if (KeyCode.listLeftMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveLeft(false);
        }

        if(KeyCode.listUpMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveUp(false);
        } else if (KeyCode.listDownMovementKeys().contains(e.getKeyCode())) {
            game.player.setMoveDown(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
