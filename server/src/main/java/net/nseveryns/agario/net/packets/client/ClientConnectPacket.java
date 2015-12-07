package net.nseveryns.agario.net.packets.client;

import io.netty.buffer.ByteBuf;
import net.nseveryns.agario.net.Packet;
import net.nseveryns.agario.net.PacketUtils;

/**
 * The packet that's sent from the client to the server.
 * Sent when a client initially connects
 *
 * @packetId 0x00
 * @packetData name of the player
 *
 * @author nseveryns
 *
 * @see net.nseveryns.agario.net.Packet
 */
public class ClientConnectPacket extends Packet {
    private final String name;

    public ClientConnectPacket(String name) {
        this.name = name;
    }

    @Override
    public void decode(ByteBuf buf) {
        String name = PacketUtils.readString(buf);
    }
}
