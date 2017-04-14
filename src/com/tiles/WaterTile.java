package com.tiles;

import com.gfx.Assets;

/**
 * Created by Rafal Predel on 4/14/2017.
 */
public class WaterTile extends Tile {
    public WaterTile(int id) {
        super(Assets.water, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
