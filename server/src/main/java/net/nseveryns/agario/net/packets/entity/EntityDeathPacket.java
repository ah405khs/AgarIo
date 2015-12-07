package net.nseveryns.agario.net.packets.entity;

import io.netty.buffer.ByteBuf;
import net.nseveryns.agario.entity.Entity;
import net.nseveryns.agario.net.Packet;

/**
 * @author nseveryns
 */
public class EntityDeathPacket extends Packet {
    private Entity player;

    public EntityDeathPacket(Entity player) {
        this.player = player;
    }

    @Override
    public void encode(ByteBuf buf) {
        buf.writeInt(player.getId());
    }
}
