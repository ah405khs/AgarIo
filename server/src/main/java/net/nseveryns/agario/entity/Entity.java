package net.nseveryns.agario.entity;

import java.awt.*;

/**
 * @author nseveryns
 */
public abstract class Entity {
    private double x;
    private double y;
    private int size;
    private boolean alive;
    private int id;

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
        //TODO: Update on client
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public abstract void kill();

    public int getId() {
        return id;
    }
}
