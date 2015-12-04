package net.nseveryns.agario.net.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.nseveryns.agario.net.Packet;

/**
 * @packetId 0x01
 * @packetData double 'x' position of spawn position
 * @packetData double 'y' position of spawn position
 * @packetData double 'z' position of spawn position
 *
 * @author nseveryns
 *
 * @see net.nseveryns.agario.net.Packet
 */
public class ClientSpawnPacket extends Packet {
    private double x;
    private double y;
    private double z;

    @Override
    public void decode(ByteBuf buf) {
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
    }

    @Override
    public void handle(ChannelHandlerContext ctx) {
        //TODO: Spawn the client
    }
}
