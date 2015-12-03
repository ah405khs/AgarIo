package net.nseveryns.agario.net.packets;

import io.netty.buffer.ByteBuf;
import net.nseveryns.agario.net.Packet;

/**
 * @author nseveryns
 */
public class ClientConnectPacket extends Packet {
    private final String name;


    public ClientConnectPacket(String name) {
        super(0x00);
        this.name = name;
    }

    @Override
    public void encode(ByteBuf buf) {
        writeString(buf, name);
    }

    private void writeString(ByteBuf buf, String name) {
        buf.writeInt(name.length());
        buf.writeBytes(name.getBytes());
    }
}
