package net.nseveryns.agario.entity;

import io.netty.channel.Channel;
import net.nseveryns.agario.net.packets.entity.EntityDeathPacket;

import java.lang.ref.WeakReference;

/**
 * @author nseveryns
 */
public class Player extends Blob {
    private final WeakReference<Channel> channel;

    public Player(Channel channel) {
        this.channel = new WeakReference<>(channel);
    }

    @Override
    public void kill() {
        Channel channel = this.channel.get();
        if (channel == null) {
            throw new NullPointerException("Player cannot be null");

        }
        channel.writeAndFlush(new EntityDeathPacket(this));
    }
}
