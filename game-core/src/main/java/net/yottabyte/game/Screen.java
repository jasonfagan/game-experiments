package net.yottabyte.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Jason Fagan
 */
public class Screen extends JPanel {

    private final Game game;

    public Screen(Game game) {
        this.game = game;
        this.setVisible(true);
        this.setSize(game.getScreenWidth(), game.getScreenHeight());
        this.setBackground(Color.BLACK);

        this.addMouseListener(game.getGameEngine());
        this.addMouseMotionListener(game.getGameEngine());
        this.addKeyListener(game.getGameEngine());

        Timer timer = new Timer(1000 / 60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();

        game.getGameEngine().onGameRunning();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        game.getGameEngine().onPaint(g2d);
    }

}
