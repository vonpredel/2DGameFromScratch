package com.states;

import com.Handler;
import com.gfx.Assets;
import com.gfx.Text;
import com.ui.ClickListener;
import com.ui.UIImageButton;
import com.ui.UIManager;

import java.awt.*;

/**
 * Created by Rafal Predel on 4/10/2017.
 */
public class CreditsState extends State {

    private UIManager uiManager;

    public CreditsState(Handler handler) {
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

        Text.drawString(g,"Created By Rafal Predel",320,100,true,Color.BLACK,Assets.font42);
        Text.drawString(g,"Version 0.1 Pre Alpha",320,200,true,Color.BLACK,Assets.font42);
    }


}
