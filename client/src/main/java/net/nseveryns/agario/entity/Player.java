package net.nseveryns.agario.entity;

import java.awt.Graphics;

/**
 * @author nseveryns
 */
public class Player extends Blob {

    public Player(int id) {
        super(id);
    }

    @Override
    public void paint(Graphics g) {
        g.drawArc((int) getX(),(int) getY(), getSize() / 5, getSize() / 5, 0, 360);
    }
}
