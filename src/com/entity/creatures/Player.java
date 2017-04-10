package com.entity.creatures;

import com.Game;
import com.Handler;
import com.gfx.Assets;

import java.awt.*;


public class Player extends Creature {

    public Player(Handler handler, float x, float y) {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 20;
        bounds.y = 20;
        bounds.width = 24;
        bounds.height = 46;
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;
        if(handler.getKeyManager().down)
            yMove = speed;
        if(handler.getKeyManager().left)
            xMove = -speed;
        if(handler.getKeyManager().rigth)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

        // hitbox coloured byRED
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
    }
}
