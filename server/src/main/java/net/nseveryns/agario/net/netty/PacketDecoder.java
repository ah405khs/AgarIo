package net.nseveryns.agario.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import net.nseveryns.agario.exceptions.InvalidPacketException;
import net.nseveryns.agario.net.Packet;
import net.nseveryns.agario.net.PacketManager;

import java.util.List;

/**
 * @author nseveryns
 */
public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        byte packetId = byteBuf.readByte();
        Packet construct = PacketManager.getInstance().construct(packetId);
        if (construct == null) {
            throw new InvalidPacketException(packetId);
        }
        construct.decode(byteBuf);
        list.add(construct);
    }
}
