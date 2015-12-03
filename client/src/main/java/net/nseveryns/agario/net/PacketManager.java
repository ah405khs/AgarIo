package net.nseveryns.agario.net;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nseveryns
 */
public final class PacketManager {
    private static PacketManager INSTANCE;
    private final Map<Byte, Class<? extends Packet>> packets = new ConcurrentHashMap<>();

    private PacketManager() {
        throw new UnsupportedOperationException("PacketManager cannot be initialized.");
    }

    public static PacketManager getInstance() {
        if (INSTANCE == null) {
            synchronized (INSTANCE) {
                if (INSTANCE == null) {
                    INSTANCE = new PacketManager();
                }
            }
        }
        return INSTANCE;
    }

    public Packet construct(byte packetId) {
        Class<? extends Packet> packet = this.packets.get(packetId);
        try {
            return packet.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
