package net.nseveryns.agario.net;

import net.nseveryns.agario.net.packets.ClientConnectPacket;
import net.nseveryns.agario.net.packets.ClientMovePacket;
import net.nseveryns.agario.net.packets.ClientSpawnPacket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author nseveryns
 */
public final class PacketManager {

    private static PacketManager INSTANCE;
    private final Map<Byte, Class<? extends Packet>> packets = new ConcurrentHashMap<>();

    public static PacketManager getInstance() {
        if (INSTANCE == null) {
            synchronized (PacketManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new PacketManager();
                }
            }
        }
        return INSTANCE;
    }

    private PacketManager() {
        registerPacket(0x00, ClientConnectPacket.class);
        registerPacket(0x01, ClientSpawnPacket.class);
        registerPacket(0x02, ClientMovePacket.class);
    }

    private void registerPacket(int id, Class<? extends Packet> packet) {
        this.packets.put((byte) id, packet);
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

    public byte getPacketId(Packet packet) {
        for (Map.Entry<Byte, Class<? extends Packet>> entry : packets.entrySet()) {
            if (entry.getValue() == packet.getClass()) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
