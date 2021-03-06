package com.entity.statics;


import com.Handler;
import com.gfx.Assets;
import com.items.Item;
import com.tiles.Tile;

import java.awt.*;

public class Rock extends StaticEntity {


    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);

        bounds.x = 16;
        bounds.y = 16;
        bounds.width = 32;
        bounds.height = 24;
    }

    @Override
    public void tick() {

    }

    @Override
    protected void die() {
        handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int)x,(int)y));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rock,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}
