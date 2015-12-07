package net.nseveryns.agario.entity;

import java.awt.Graphics;

/**
 * @author nseveryns
 */
public abstract class Entity {
    private final int id;
    private double x;
    private double y;
    private int size;
    private boolean alive;

    protected Entity(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public abstract void paint(Graphics g);
}
