package com.states;

import com.Handler;
import com.gfx.Assets;
import com.ui.ClickListener;
import com.ui.UIImageButton;
import com.ui.UIManager;

import java.awt.*;


public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
//        handler.getMouseManager().setUiManager(uiManager);


        uiManager.addObject(new UIImageButton(256, 50, 128, 64, Assets.MenuBtn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setCurrentState(handler.getGame().gameState);
            }
        }));
        uiManager.addObject(new UIImageButton(256, 150, 128, 64, Assets.MenuBtn_settings, new ClickListener() {
            @Override
            public void onClick() {
                State.setCurrentState(handler.getGame().settingsState);
                handler.getMouseManager().setUiManager(null);
            }
        }));
        uiManager.addObject(new UIImageButton(256, 250, 128, 64, Assets.MenuBtn_credits, new ClickListener() {
            @Override
            public void onClick() {
                State.setCurrentState(handler.getGame().creditsState);
                handler.getMouseManager().setUiManager(null);
            }
        }));
        uiManager.addObject(new UIImageButton(256, 350, 128, 64, Assets.MenuBtn_exit, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                System.exit(1);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
        if(handler.getMouseManager().getUiManager() == null)
            handler.getMouseManager().setUiManager(uiManager);
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
