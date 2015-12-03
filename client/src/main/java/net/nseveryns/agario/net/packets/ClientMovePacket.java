package net.nseveryns.agario.net.packets;

import io.netty.buffer.ByteBuf;
import net.nseveryns.agario.net.Packet;

/**
 * @author nseveryns
 */
public class ClientMovePacket extends Packet {
    private final String name;
    private final double x;
    private final double y;
    private final double z;

    public ClientMovePacket(String name, double x, double y, double z) {
        super(0x01);
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public ClientMovePacket() {
        //For decoding
        this(null, 0, 0, 0);
    }

    @Override
    public void encode(ByteBuf buf) {
        super.encode(buf);
    }
}
