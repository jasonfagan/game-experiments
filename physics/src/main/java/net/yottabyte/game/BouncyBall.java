package net.yottabyte.game;

import java.awt.*;

/**
 * @author Jason Fagan
 */
public class BouncyBall {

    private int x;
    private int y;
    private int vx;
    private int vy;
    private int radius;
    private int drag;
    private int mass;

    public BouncyBall(int x, int y, int vx, int vy, int radius, int mass, int drag) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.radius = radius;
        this.mass = mass;
        this.drag = drag;
    }

    public void move(Rectangle rect)
    {
        x += vx;
        y += vy;

        hitWall(rect);
    }

    public void paint(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, radius, radius);
    }

    public void hitWall(Rectangle rect)
    {
        if (x <= 0) {
            x = 0;
            vx = -(vx * drag);
        } else if (x + radius >= rect.width) {
            x = rect.width - radius;
            vx = -(vx * drag);
        }

        if (y < 0) {
            y = 0;
            vy = -(vy * drag);
        } else if (y + (radius * 2) >= rect.height) {
            y = rect.height - (radius * 2);
            vy = -(vy * drag);
        }
    }

    // see http://en.wikipedia.org/wiki/Elastic_collision
    public boolean hasCollidedWith(BouncyBall ball) {
        int dx = Math.abs(getCenterX() - ball.getCenterX());
        int dy = Math.abs(getCenterY() - ball.getCenterY());

        double distance = Math.sqrt(dx * dx + dy * dy);

        return  distance <= radius;
    }

    public void handleCollision(BouncyBall ball) {
        int dx = getCenterX() - ball.getCenterX();
        int dy = getCenterY() - ball.getCenterY();

        // Calculate collision angle
        double ca = Math.atan2(dy, dx);

        // Calculate force magnitudes
        double mgt1 = Math.sqrt(vx * vx + vy * vy);
        double mgt2 = Math.sqrt(ball.getVx() * ball.getVx() + ball.getVy() * ball.getVy());
        // Calculate direction
        double dir1 = Math.atan2(vy, vx);
        double dir2 = Math.atan2(ball.getVy(), ball.getVx());

        // Calculate new velocities
        double vx1 = mgt1 * Math.cos(dir1 - ca);
        double vy1 = mgt1 * Math.sin(dir1 - ca);
        double vx2 = mgt2 * Math.cos(dir2 - ca);
        double vy2 = mgt2 * Math.sin(dir2 - ca);

        double vfx1 = ((mass - ball.getMass()) * vx1 + (ball.getMass() + ball.getMass()) * vx2) / (mass + ball.getMass());
        double fvx2 = ((mass + mass) * vx1 + (ball.getMass() - mass) * vx2) / (mass + ball.getMass());
        double fvy1 = vy1;
        double fvy2 = vy2;

        vx = (int) (Math.cos(ca) * vfx1 + Math.cos(ca + Math.PI / 2) * fvy1);
        vx = (int) (Math.sin(ca) * vfx1 + Math.sin(ca + Math.PI / 2) * fvy1);

        ball.setVx((int) (Math.cos(ca) * fvx2 + Math.cos(ca + Math.PI / 2) * fvy2));
        ball.setVy((int) (Math.sin(ca) * fvx2 + Math.sin(ca + Math.PI / 2) * fvy2));
    }

    public int getCenterX() {
        return x - radius / 2;
    }

    public int getCenterY() {
        return y - radius / 2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getDrag() {
        return drag;
    }

    public void setDrag(int drag) {
        this.drag = drag;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }
}
