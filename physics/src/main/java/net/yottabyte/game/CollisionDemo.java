package net.yottabyte.game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @author Jason Fagan
 */
public class CollisionDemo implements GameEngine {

    private boolean running = false;

    private final java.util.List<BouncyBall> balls = new ArrayList<BouncyBall>();

    private final Game game;

    public static void main(String... args) {
        new CollisionDemo();
    }

    public CollisionDemo() {
        this.game = new Game(this);
    }

    @Override
    public void onScreenChanged(Rectangle rect) {
    }

    @Override
    public void onGameInitialize(Rectangle rect) {
        Random rand = new Random(new Date().getTime());

        for (int i=0; i<5; i++) {
            int x = rand.nextInt(rect.width);
            int y = rand.nextInt(rect.height);
            int vx = rand.nextInt(5);
            int vy = rand.nextInt(5);
            balls.add(new BouncyBall(x, y, vx, vy, 25, 10, 1));
        }
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
            for (int i=0; i<balls.size(); i++) {
                BouncyBall ball = balls.get(i);
                ball.move(game.getScreenRectangle());
                ball.paint(g2d);
            }

            for (int i = 0; i < balls.size(); i++) {
                for (int j = i + 1; j < balls.size(); j++) {
                    if (balls.get(i).hasCollidedWith(balls.get(j))) {
                        balls.get(i).handleCollision(balls.get(j));
                    }
                }
            }
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
