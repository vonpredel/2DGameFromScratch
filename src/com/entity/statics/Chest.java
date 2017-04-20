package com.entity.statics;

import com.Handler;
import com.gfx.Assets;
import com.items.Item;
import com.tiles.Tile;

import java.awt.*;

/**
 * Created by Rafal Predel on 4/20/2017.
 */
public class Chest extends StaticEntity {
    public Chest(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT);

        bounds.x = 8;
        bounds.y = 28;
        bounds.width = 48;
        bounds.height = 36;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.chest,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
    }

    @Override
    protected void die() {
        for (int i = 0; i <= 32; i+=8) {
            for (int j = 0; j <= 32; j+=8) {
                handler.getWorld().getItemManager().addItem(Item.goldItem.createNew((int)x+i,(int)y+j));
            }
        }
    }
}
