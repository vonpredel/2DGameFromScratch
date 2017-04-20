package com.tiles;

import com.gfx.Assets;

/**
 * Created by Rafal Predel on 4/20/2017.
 */

public class SpikesTile extends Tile{
    public SpikesTile(int id) {
        super(Assets.spikes, id);
    }

    @Override
    public boolean isDamagingTile() {
        return true;
    }
}
