package net.yottabyte.game;

import javax.swing.*;
import java.awt.*;

/**
 * @author Jason Fagan
 */
public class Game {
    public Settings settings;

    private JFrame frame;

    private final GraphicsDevice graphicsDevice;
    private final GameEngine gameEngine;

    private int monitorHeight;
    private int monitorWidth;


    public Game(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        this.monitorHeight = graphicsDevice.getDisplayMode().getHeight();
        this.monitorWidth = graphicsDevice.getDisplayMode().getWidth();

        settings = new Settings();

        gameEngine.onGameInitialize();

        initGUI();

    }

    public void quit() {
        gameEngine.onGameShutdown();
    }

    private void initGUI() {
        frame = new JFrame();
        frame.setBounds(monitorWidth / 2 - settings.getScreenWidth() / 2,
                monitorHeight / 2 - settings.getScreenHeight() / 2,
                settings.getScreenWidth(),
                settings.getScreenHeight());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new Screen(this), BorderLayout.CENTER);

        if(settings.isFullScreen()){
            frame.dispose();
            frame.setUndecorated(true);
            graphicsDevice.setFullScreenWindow(frame);
            frame.setVisible(true);
        }

        gameEngine.onScreenChanged(frame.getBounds());
    }

    public int getScreenWidth() {
        return settings.getScreenWidth();
    }

    public int getScreenHeight() {
        return settings.getScreenHeight();
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }
}
