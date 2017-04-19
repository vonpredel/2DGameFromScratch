package com.entity.creatures;

import com.Handler;
import com.gfx.Animation;
import com.gfx.Assets;
import com.items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Rafal Predel on 4/13/2017.
 */
public class Zombie extends Creature {

    //Animations
    private Animation animDown,animUp,animLeft,animRight;

    public Zombie(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 20;
        bounds.y = 20;
        bounds.width = 24;
        bounds.height = 46;

        //Animations
        animDown = new Animation(500, Assets.zombie_down);
        animUp = new Animation(500, Assets.zombie_up);
        animLeft = new Animation(500, Assets.zombie_left);
        animRight = new Animation(500, Assets.zombie_right);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        //Movement
        moveAI();
        move();
    }

    private void moveAI() {
        xMove = 0;
        xMove =- speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0) {
            return animLeft.getCurrentFrame();
        }else if(xMove > 0) {
            return animRight.getCurrentFrame();
        }else if(yMove < 0) {
            return animUp.getCurrentFrame();
        }else if(yMove > 0) {
            return animDown.getCurrentFrame();
        }else {
            return Assets.zombie;
        }
    }

    @Override
    protected void die() {
        handler.getWorld().getItemManager().addItem(Item.goldItem.createNew((int)x,(int)y));
    }


}
