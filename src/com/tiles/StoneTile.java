package com.tiles;

import com.gfx.Assets;

/**
 * Created by OSTRa_000 on 4/9/2017.
 */
public class StoneTile extends Tile {
    public StoneTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
