package com.entity.creatures;

import com.Handler;
import com.entity.Entity;
import com.gfx.Animation;
import com.gfx.Assets;
import com.inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Creature {

    //Animations
    private Animation animDown,animUp,animLeft,animRight;
    //Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    //Inventory
    private Inventory inventory;

//    private boolean hit = false;
//    private Entity target;

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

        inventory = new Inventory(handler);
    }

    @Override
    public void tick() {
        //Animations
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();
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
//        hit = false;

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

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

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar)) {
                e.hurt(1);
                System.out.println(e.getHealth());
//                hit = true;
//                target = e;
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

        //hitSprite TODO
//        if(hit) {
//            g.setColor(Color.red);
//            Rectangle a = new Rectangle(target.getCollisionBounds((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset())));
//            g.fillRect((int) a.getX(), (int) a.getY(), (int) a.getWidth(), (int) a.getHeight());
//        }
//         hitbox coloured byRED
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width,bounds.height);

    }

    public void postRender(Graphics g) {
        inventory.render(g);
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
