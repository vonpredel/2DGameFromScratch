package com.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by OSTRa_000 on 4/8/2017.
 */
public class SpriteSheet {

    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    public BufferedImage crop(int x, int y ,int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }

}
