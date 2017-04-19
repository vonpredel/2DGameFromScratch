package com.entity.creatures;

import com.Handler;
import com.entity.Entity;
import com.gfx.Animation;
import com.gfx.Assets;
import com.gfx.Text;
import com.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Creature {

    //Animations
    private Animation animDown,animUp,animLeft,animRight,animAttack;
    //Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    //Inventory
    private Inventory inventory;
    private boolean attacking = false;

    long animAttackTimer = System.currentTimeMillis();

    //TESTING
    private int targetX,targetY,targetWidth,targetHeight;


    public Player(Handler handler, float x, float y) {
        super(handler,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

        bounds.x = 20;
        bounds.y = 20;
        bounds.width = 24;
        bounds.height = 46;

        //Animations
        animDown = new Animation(500, Assets.player_down);
        animUp = new Animation(500, Assets.player_up);
        animLeft = new Animation(500, Assets.player_left);
        animRight = new Animation(500, Assets.player_right);
        animAttack = new Animation(100,Assets.attackAnimation);

        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
        animAttack.tick();
        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        // Attack
        checkAttacks();
        //Inventory
        inventory.tick();
    }

    private void checkAttacks() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        animAttackTimer = System.currentTimeMillis();

        Rectangle cb = getCollisionBounds(0,0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().attack && handler.getKeyManager().up) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(handler.getKeyManager().attack && handler.getKeyManager().down) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(handler.getKeyManager().attack && handler.getKeyManager().left) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(handler.getKeyManager().attack && handler.getKeyManager().rigth) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else {
            return;
        }

        attackTimer = 0;
        attacking = true;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar)) {
                e.hurt(getDamage());

                ///Testing
                targetX = (int)e.getX();
                targetY = (int)e.getY();
                targetWidth = e.getWidth();
                targetHeight = e.getHeight();

                return;
            }
        }



    }


    @Override
    protected void die() {
        System.out.println("You loose !");
    }

    public void getInput() {
        xMove = 0;
        yMove = 0;

        if(inventory.isActive())
            return;

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
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }

    public void postRender(Graphics g) {
        inventory.render(g);
        attackAnimation(g);
    }

    private void attackAnimation(Graphics g) {
        if(attacking) {
            if(targetHeight > 64) {
                targetHeight -= 64;
            }
            g.drawImage(animAttack.getCurrentFrame(),(int) (targetX - handler.getGameCamera().getxOffset()) + (targetWidth/4), (int) (targetY - handler.getGameCamera().getyOffset()) + (targetHeight/4),32,32,null);
            Text.drawString(g,String.valueOf(getDamage()),(int) (targetX - handler.getGameCamera().getxOffset() + (targetWidth /2)), (int) (targetY - handler.getGameCamera().getyOffset() + (targetHeight /2)),true,Color.RED, Assets.font28);
            long elapsedTime = System.currentTimeMillis() - animAttackTimer;
            if(elapsedTime < 500)
                return;
            attacking = false;
            targetX = -100;
            targetY = -100;
            targetWidth = -100;
            targetHeight = -100;
        }
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
            return Assets.player;
        }
    }


    //GETTERS SETTERS

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
