package net.nseveryns.agario.net;

import com.google.common.base.Preconditions;
import io.netty.buffer.ByteBuf;
import net.nseveryns.agario.exceptions.MalformedPacketException;

import java.nio.charset.Charset;

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

    public static String readString(ByteBuf buf) {
        Preconditions.checkArgument(buf.isReadable(), "Buf must be readable");

        int length = buf.readInt();
        if (length < buf.readableBytes()) throw new MalformedPacketException("Length of string too long for buffer");

        byte[] bytes = new byte[length];
        buf.readBytes(bytes);
        return new String(bytes);
    }
}
