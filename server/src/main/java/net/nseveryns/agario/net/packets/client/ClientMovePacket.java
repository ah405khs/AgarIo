package net.nseveryns.agario.net.packets.client;

import io.netty.buffer.ByteBuf;
import net.nseveryns.agario.net.Packet;

/**
 * The packet that is sent to the server from the client.
 * This will be used to update the movements on to the server.
 *
 * @packetId 0x02
 * @packetData the id of the blob
 * @packetData double 'x' position of blob
 * @packetData double 'y' position of blob
 * @packetData double 'z' position of blob
 *
 * @author nseveryns
 *
 * @see net.nseveryns.agario.net.Packet
 */
public class ClientMovePacket extends Packet {
    private final int id;
    private final double x;
    private final double y;
    private final double z;

    public ClientMovePacket(int id, double x, double y, double z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void encode(ByteBuf buf) {
        buf.writeInt(id);
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
    }
}
