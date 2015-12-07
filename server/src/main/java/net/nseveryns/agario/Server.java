package net.nseveryns.agario;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.nseveryns.agario.net.netty.PipelineInitializer;

/**
 * @author nseveryns
 */
public class Server {

    public Server() {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            new ServerBootstrap()
                    .group(group)
                    .childHandler(new PipelineInitializer())
                    .channel(NioServerSocketChannel.class)
                    .bind(39216).sync().channel().closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
