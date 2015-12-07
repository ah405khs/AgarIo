package net.nseveryns.agario.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.nseveryns.agario.net.Packet;
import net.nseveryns.agario.net.PacketManager;

/**
 * @author nseveryns
 */
public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf byteBuf) throws Exception {
        byte packetId = PacketManager.getInstance().getPacketId(packet);
        byteBuf.writeByte(packetId);
        packet.encode(byteBuf);

        ctx.writeAndFlush(byteBuf);
    }
}
