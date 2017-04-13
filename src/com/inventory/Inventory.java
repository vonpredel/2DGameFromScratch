package com.inventory;


import com.Handler;
import com.gfx.Assets;
import com.gfx.Text;
import com.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    // Inv
    private int invX = 64, invY = 48,
            invWidth = 512, invHeight = 384,
            invListCenterX = invX + 171,
            invListCenterY = invY + invHeight / 2 + 5,
            invListSpacing = 30;

    //Image
    private int invImageX = 452, invImageY = 82,
                invImageWidth = 64, invImageHeight = 64;

    //Counter
    private int invCountX = 484, invCountY = 171;

    //Index of selected item
    private int selectedItem = 0;

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        // TESTING !!!!!!!!!!!!! DELETE IT !!!!!!!!!!!!!!!!
//        addItem(Item.rockItem.createNew(5));
//        addItem(Item.woodItem.createNew(3));
    }

    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active)
            return;

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_UP))
            selectedItem--;
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_DOWN))
            selectedItem++;

        if(selectedItem < 0)
            selectedItem = inventoryItems.size() - 1;
        else if(selectedItem >= inventoryItems.size())
            selectedItem = 0;
    }
    public void render(Graphics g) {
        if(!active)
            return;

        g.drawImage(Assets.inventoryScreen,invX,invY,invWidth,invHeight,null);

        int len = inventoryItems.size();
        if (len == 0)
            return;

        for (int i = -5; i < 6; i++) {
            if(selectedItem + i < 0 || selectedItem + i >= len)
                continue;
            if(i == 0) {
                Text.drawString(g,"> " +inventoryItems.get(selectedItem + i).getName()+" <",
                        invListCenterX,invListCenterY + i * invListSpacing,
                        true,Color.YELLOW, Assets.font28);
            } else {
                Text.drawString(g,inventoryItems.get(selectedItem + i).getName(),
                        invListCenterX,invListCenterY + i * invListSpacing,
                        true,Color.WHITE, Assets.font28);
            }
        }

        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(),invImageX,invImageY,invImageWidth,invImageHeight,null);
        Text.drawString(g,Integer.toString(item.getCount()),invCountX,invCountY,true,Color.WHITE,Assets.font28);


    }

    //Inventory Methods

    public void addItem(Item item) {
        for (Item i : inventoryItems) {
            if(i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }


    //Getters and Setters


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public boolean isActive() {
        return active;
    }
}
