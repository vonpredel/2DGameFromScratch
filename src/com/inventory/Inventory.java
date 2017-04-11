package com.inventory;


import com.Handler;
import com.gfx.Assets;
import com.items.Item;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private int invX = 64, invY = 0,
            invWidth = 512, invHeight = 384,
            invListCenterX = invX + 171,
            invListCenterY = invY + invHeight / 2 + 5;

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
    }

    public void tick() {
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
            active = !active;
        if(!active)
            return;
    }
    public void render(Graphics g) {
        if(!active)
            return;

        g.drawImage(Assets.inventoryScreen,invX,invY,invWidth,invHeight,null);
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
}
