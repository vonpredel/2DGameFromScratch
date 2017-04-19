package com.ui;

import com.entity.creatures.Player;
import com.gfx.Assets;
import com.gfx.Text;

import java.awt.*;

/**
 * Created by Rafal Predel on 4/19/2017.
 */
public class HealthBar extends UIObject {

    private static int x = 5,y = 5,width = 200,height = 20;
    private static int xText = width/2 + x,yText = height/2 + y;
    private int maxHealth,currentHealth;
    private Player player;
    private int healthPoint;

    public HealthBar(Player player) {
        super(x, y, width, height);
        this.player = player;
        this.maxHealth = player.getMaxHealth();
        this.currentHealth = player.getCurrentHealth();
    }

    @Override
    public void tick() {
        maxHealth = player.getMaxHealth();
        currentHealth = player.getCurrentHealth();
        healthPoint = width / maxHealth;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(x,y,width,height);
        g.setColor(Color.red);
        g.fillRect(x,y,healthPoint*currentHealth,height);
        Text.drawString(g,"HP : " + player.getCurrentHealth() + " / " + player.getMaxHealth(),xText,yText,true,Color.WHITE,Assets.font18);
    }

    @Override
    public void onClick() {

    }
}
