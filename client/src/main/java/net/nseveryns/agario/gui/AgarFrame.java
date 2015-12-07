package net.nseveryns.agario.gui;

import com.google.common.collect.ImmutableList;
import net.nseveryns.agario.entity.Entity;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author nseveryns
 */
public class AgarFrame extends JFrame {
    private final List<Entity> entities = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void paint(Graphics g) {
        entities.stream().filter(Entity::isAlive).forEach(entity -> entity.paint(g));
    }

    public void addEntity(Entity entity) {
        lock.readLock().lock();
        try {
            this.entities.add(entity);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void removeEntity(Entity entity) {
        lock.readLock().lock();
        try {
            this.entities.add(entity);
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Entity> getEntities() {
        return ImmutableList.copyOf(entities);
    }
}
