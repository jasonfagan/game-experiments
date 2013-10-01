package net.yottabyte.game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Jason Fagan
 */
interface GameEngine extends KeyListener, MouseListener, MouseMotionListener {

    void onScreenChanged(Rectangle rect);
    void onGameInitialize();
    void onGameShutdown();
    void onGameRunning();
    void onPaint(Graphics2D g2d);

}
