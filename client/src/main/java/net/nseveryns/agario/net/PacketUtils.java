package net.nseveryns.agario.net;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;

/**
 * @author nseveryns
 */
public final class PacketUtils {

    private PacketUtils() {
        throw new UnsupportedOperationException("The PacketUtils class cannot be initialized.");
    }

    public static void writeString(ByteBuf buf, String content) {
        Preconditions.checkArgument(content.isEmpty(), "Content can't be empty.");
        buf.writeInt(content.length());
        buf.writeBytes(content.getBytes());
    }
}
