package com.gfx;


import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    private static final int dlugosc = 32;

    public static BufferedImage player, grass, dirt, tree, stone;
    public static BufferedImage riverLR,riverUD,riverLU,riverRU,riverLD,riverRD,riverLRUP,riverUDBridge,riverLRBridge;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

        player = sheet.crop(0,0, dlugosc, dlugosc);
        grass = sheet.crop(dlugosc,0, dlugosc, dlugosc);
        dirt = sheet.crop(dlugosc *2,0, dlugosc, dlugosc);
        tree = sheet.crop(dlugosc *3,0, dlugosc, dlugosc);
        stone = sheet.crop(0, dlugosc, dlugosc, dlugosc);
        riverLR = sheet.crop(dlugosc *2, dlugosc *3, dlugosc, dlugosc);
        riverUD = sheet.crop(dlugosc *3, dlugosc *2, dlugosc, dlugosc);
        riverLU = sheet.crop(dlugosc*3,dlugosc*3, dlugosc, dlugosc);
        riverRU = sheet.crop(dlugosc,dlugosc*3, dlugosc, dlugosc);
        riverLD = sheet.crop(dlugosc*2,dlugosc*2, dlugosc, dlugosc);
        riverRD = sheet.crop(dlugosc,dlugosc*2, dlugosc, dlugosc);
        riverLRUP = sheet.crop(0,dlugosc*3, dlugosc, dlugosc);
        riverUDBridge = sheet.crop(dlugosc*2,dlugosc, dlugosc, dlugosc);
        riverLRBridge = sheet.crop(dlugosc,dlugosc, dlugosc, dlugosc);



    }

}
