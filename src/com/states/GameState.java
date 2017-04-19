package com.states;

import com.Handler;
import com.ui.HealthBar;
import com.ui.UIManager;
import com.worlds.World;

import java.awt.*;

public class GameState extends State {

    private World world;
    private UIManager uiManager;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
        uiManager = new UIManager(handler);
        handler.setWorld(world);
        uiManager.addObject(new HealthBar(handler.getWorld().getEntityManager().getPlayer()));
    }

    @Override
    public void tick() {
        world.tick();
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        uiManager.render(g);
    }
}
