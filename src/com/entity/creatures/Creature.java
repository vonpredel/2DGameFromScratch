package com.entity.creatures;

import com.Handler;
import com.entity.Entity;
import com.tiles.Tile;


public abstract class Creature extends Entity {


    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;
    public static final int DEFAULT_DAMAGE = 1;


    protected float speed;
    protected int damage;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        damage = DEFAULT_DAMAGE;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        if(!checkEntityCollisions(xMove,0f))
            moveX();
        if(!checkEntityCollisions(0f,yMove))
            moveY();
    }

    public void moveX() {
        if (xMove > 0) { //Moving rigth
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

            ////////////////////
            // TEMPORARY CODE // EACH ONE OF THIS FOUR IFS ARE GOING TO DELETE !!!
            ////////////////////
            if(onDamagingTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                    onDamagingTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                setCurrentHealth(getCurrentHealth()-1);
            }

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
            }

        }else if (xMove < 0) { //Moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

            ////////////////////
            // TEMPORARY CODE // EACH ONE OF THIS FOUR IFS ARE GOING TO DELETE !!!
            ////////////////////
            if(onDamagingTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                    onDamagingTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                setCurrentHealth(getCurrentHealth()-1);
            }

            if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }else{
                x = tx * Tile.TILE_WIDTH + Tile.TILE_WIDTH - bounds.x;
            }
        }
    }

    public void moveY() {
        if(yMove < 0) { // Moving Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;


            ////////////////////
            // TEMPORARY CODE // EACH ONE OF THIS FOUR IFS ARE GOING TO DELETE !!!
            ////////////////////
            if(onDamagingTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                    onDamagingTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                setCurrentHealth(getCurrentHealth()-1);
            }

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - bounds.y;
            }

        }else if (yMove > 0) { // Moving Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;


            ////////////////////
            // TEMPORARY CODE // EACH ONE OF THIS FOUR IFS ARE GOING TO DELETE !!!
            ////////////////////
            if(onDamagingTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                    onDamagingTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                setCurrentHealth(getCurrentHealth()-1);
            }

            if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                y += yMove;
            }else {
                y = ty * Tile.TILE_HEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x,y).isSolid();
    }
    protected boolean onDamagingTile(int x, int y) {
        return handler.getWorld().getTile(x,y).isDamagingTile();
    }

    //GETTERS SETTERS

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
