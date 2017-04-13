package com.states;

import com.Game;
import com.Handler;
import com.gfx.Assets;
import com.ui.ClickListener;
import com.ui.UIImageButton;
import com.ui.UIManager;

import java.awt.*;


public class SettingsState extends State {

    private UIManager uiManager;

    public SettingsState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);

        uiManager.addObject(new UIImageButton(32, 400, 128, 64, Assets.Btn_back, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setCurrentState(handler.getGame().menuState);
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
