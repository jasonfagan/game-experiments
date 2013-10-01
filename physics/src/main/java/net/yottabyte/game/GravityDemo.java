package net.yottabyte.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author Jason Fagan
 */
public class GravityDemo implements GameEngine {

    private boolean running = false;

    public static void main(String ... args) {
        new Game(new GravityDemo());
    }

    @Override
    public void onScreenChanged(Rectangle rect) {
    }

    @Override
    public void onGameInitialize() {
    }

    @Override
    public void onGameShutdown() {
        running = false;
    }

    @Override
    public void onGameRunning() {
        running = true;
    }

    @Override
    public void onPaint(Graphics2D g2d) {
        if (running) {
            g2d.setColor(Color.CYAN);
            g2d.draw3DRect(0, 0, 20, 20, true);
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}
