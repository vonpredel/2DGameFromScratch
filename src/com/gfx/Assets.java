package com.gfx;


import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    private static final int dlugosc = 32;

    public static BufferedImage player, grass, dirt, tree, stone;
    public static BufferedImage[] player_down,player_up,player_left,player_rigth;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet PlayerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/PlayerSheet.png"));

        player_down = new BufferedImage[2];
        player_up= new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_rigth = new BufferedImage[2];


        player = PlayerSheet.crop(0,dlugosc*2,dlugosc,dlugosc);
        player_down[0] = PlayerSheet.crop(0,0,dlugosc,dlugosc);
        player_down[1] = PlayerSheet.crop(dlugosc,0,dlugosc,dlugosc);
        player_up[0] = PlayerSheet.crop(dlugosc*2,0,dlugosc,dlugosc);
        player_up[1] = PlayerSheet.crop(dlugosc*3,0,dlugosc,dlugosc);
        player_rigth[0] = PlayerSheet.crop(0,dlugosc,dlugosc,dlugosc);
        player_rigth[1] = PlayerSheet.crop(dlugosc,dlugosc,dlugosc,dlugosc);
        player_left[0] = PlayerSheet.crop(dlugosc*2,dlugosc,dlugosc,dlugosc);
        player_left[1] = PlayerSheet.crop(dlugosc*3,dlugosc,dlugosc,dlugosc);


        grass = sheet.crop(0,0, dlugosc, dlugosc);
        dirt = sheet.crop(dlugosc,0, dlugosc, dlugosc);
        tree = sheet.crop(dlugosc *3,0, dlugosc, dlugosc);
        stone = sheet.crop(dlugosc*2, 0, dlugosc, dlugosc);



    }

}
