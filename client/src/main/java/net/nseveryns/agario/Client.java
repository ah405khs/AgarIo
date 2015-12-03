package net.nseveryns.agario;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import net.nseveryns.agario.net.netty.PipelineInitializer;

/**
 * @author nseveryns
 */
public class Client {
    private final EventLoopGroup group;

    protected Client() {
        this.group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        {
            bootstrap.group(this.group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new PipelineInitializer());
        }
        bootstrap.connect(null, null); //TODO: Connect to a host
    }
}
