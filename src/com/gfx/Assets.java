package com.gfx;


import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    private static final int dlugosc = 32;

    // Charac
    public static BufferedImage player, zombie;
    // Tiles
    public static BufferedImage grass, dirt, stone;
    // Static Envi
    public static BufferedImage tree, rock;
    // Items
    public static BufferedImage wood;
    // Inventory
    public static BufferedImage inventoryScreen;

    //Animation
    public static BufferedImage[] player_down,player_up,player_left, player_right;
    public static BufferedImage[] zombie_down,zombie_up,zombie_left,zombie_right;

    // Buttons
    public static BufferedImage[] MenuBtn_start,MenuBtn_exit,MenuBtn_settings,MenuBtn_credits,Btn_back;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/textures/PlayerSheet.png"));
        SpriteSheet zombieSheet = new SpriteSheet(ImageLoader.loadImage("/textures/ZombieSheet.png"));
        SpriteSheet menuBtnSheet = new SpriteSheet(ImageLoader.loadImage("/textures/MenuButtons.png"));
        SpriteSheet itemsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/itemsSheet.png"));

        inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");

        //MenuButtons
        MenuBtn_start = new BufferedImage[2];
        MenuBtn_start[0] = menuBtnSheet.crop(0,0,dlugosc*2,dlugosc);
        MenuBtn_start[1] = menuBtnSheet.crop(dlugosc*2,0,dlugosc*2,dlugosc);
        MenuBtn_exit = new BufferedImage[2];
        MenuBtn_exit[0] = menuBtnSheet.crop(0,dlugosc,dlugosc*2,dlugosc);
        MenuBtn_exit[1] = menuBtnSheet.crop(dlugosc*2,dlugosc,dlugosc*2,dlugosc);
        MenuBtn_settings = new BufferedImage[2];
        MenuBtn_settings[0] = menuBtnSheet.crop(0,dlugosc*2,dlugosc*2,dlugosc);
        MenuBtn_settings[1] = menuBtnSheet.crop(dlugosc*2,dlugosc*2,dlugosc*2,dlugosc);
        MenuBtn_credits = new BufferedImage[2];
        MenuBtn_credits[0] = menuBtnSheet.crop(0,dlugosc*3,dlugosc*2,dlugosc);
        MenuBtn_credits[1] = menuBtnSheet.crop(dlugosc*2,dlugosc*3,dlugosc*2,dlugosc);

        //Buttons
        Btn_back = new BufferedImage[2];
        Btn_back[0] = menuBtnSheet.crop(0,dlugosc*4,dlugosc*2,dlugosc);
        Btn_back[1] = menuBtnSheet.crop(dlugosc*2,dlugosc*4,dlugosc*2,dlugosc);

        // Player
        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_right = new BufferedImage[2];

        player = playerSheet.crop(0,dlugosc*2,dlugosc,dlugosc);
        player_down[0] = playerSheet.crop(0,0,dlugosc,dlugosc);
        player_down[1] = playerSheet.crop(dlugosc,0,dlugosc,dlugosc);
        player_up[0] = playerSheet.crop(dlugosc*2,0,dlugosc,dlugosc);
        player_up[1] = playerSheet.crop(dlugosc*3,0,dlugosc,dlugosc);
        player_right[0] = playerSheet.crop(0,dlugosc,dlugosc,dlugosc);
        player_right[1] = playerSheet.crop(dlugosc,dlugosc,dlugosc,dlugosc);
        player_left[0] = playerSheet.crop(dlugosc*2,dlugosc,dlugosc,dlugosc);
        player_left[1] = playerSheet.crop(dlugosc*3,dlugosc,dlugosc,dlugosc);

        // Zombie
        zombie_down = new BufferedImage[2];
        zombie_up = new BufferedImage[2];
        zombie_left = new BufferedImage[2];
        zombie_right = new BufferedImage[2];

        zombie = zombieSheet.crop(0,dlugosc*2,dlugosc,dlugosc);
        zombie_down[0] = zombieSheet.crop(0,0,dlugosc,dlugosc);
        zombie_down[1] = zombieSheet.crop(dlugosc,0,dlugosc,dlugosc);
        zombie_up[0] = zombieSheet.crop(dlugosc*2,0,dlugosc,dlugosc);
        zombie_up[1] = zombieSheet.crop(dlugosc*3,0,dlugosc,dlugosc);
        zombie_right[0] = zombieSheet.crop(0,dlugosc,dlugosc,dlugosc);
        zombie_right[1] = zombieSheet.crop(dlugosc,dlugosc,dlugosc,dlugosc);
        zombie_left[0] = zombieSheet.crop(dlugosc*2,dlugosc,dlugosc,dlugosc);
        zombie_left[1] = zombieSheet.crop(dlugosc*3,dlugosc,dlugosc,dlugosc);

        // Tiles
        grass = sheet.crop(0,0, dlugosc, dlugosc);
        dirt = sheet.crop(dlugosc,0, dlugosc, dlugosc);
        stone = sheet.crop(dlugosc*2, 0, dlugosc, dlugosc);

        //Envi
        tree = sheet.crop(dlugosc *3,0, dlugosc, dlugosc);
        rock = sheet.crop(dlugosc,dlugosc*3,dlugosc,dlugosc);

        //Items
        wood = itemsSheet.crop(0,0,dlugosc,dlugosc);
    }

}
