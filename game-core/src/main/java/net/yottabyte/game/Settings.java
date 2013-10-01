package net.yottabyte.game;

import java.io.Serializable;

/**
 * @author Jason Fagan
 */
public class Settings implements Serializable {
    private static final int SCREEN_HEIGHT = 600;
    private static final int SCREEN_WIDTH = 800;

    private int screenWidth;
    private int screenHeight;
    private boolean fullScreen;

    public Settings() {
        screenWidth = SCREEN_WIDTH;
        screenHeight = SCREEN_HEIGHT;
        fullScreen = false;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public boolean isFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(boolean fullScreen) {
        this.fullScreen = fullScreen;
    }
}
