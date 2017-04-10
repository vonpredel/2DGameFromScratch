package com.entity.statics;

import com.Handler;
import com.gfx.Assets;
import com.tiles.Tile;

import java.awt.*;

/**
 * Created by Rafal Predel on 4/10/2017.
 */
public class Tree extends StaticEntity {
    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH,Tile.TILE_HEIGHT*2);

        bounds.x = 24;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 46;
        bounds.height = (int) (height - height / 1.5f);
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tree,(int)(x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()),width,height,null);
    }
}
