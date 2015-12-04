package net.nseveryns.agario.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author nseveryns
 */
public class Packet {
    public void encode(ByteBuf buf) {
        throw new UnsupportedOperationException(getClass().getSimpleName().concat(" should implement #encode(ByteBuf)"));
    }

    public void decode(ByteBuf buf) {
        throw new UnsupportedOperationException(getClass().getSimpleName().concat(" should implement #decode(ByteBuf)"));
    }

    public void handle(ChannelHandlerContext ctx) {
        throw new UnsupportedOperationException(getClass().getSimpleName().concat(" should implement #handle(ChannelHandlerContext)"));
    }
}
