package net.nseveryns.agario.exceptions;

/**
 * Thrown when an invalid packet is received.
 *
 * @author nseveryns
 */
public class InvalidPacketException extends RuntimeException {

    public InvalidPacketException(byte packetId) {
        this(packetId, " wasn't able to be handled.");
    }

    public InvalidPacketException(byte packetId, String s) {
        super(String.format("0x%02x", packetId).concat(s));
    }
}
