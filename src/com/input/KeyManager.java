package com.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by OSTRa_000 on 4/9/2017.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, rigth;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        rigth = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
