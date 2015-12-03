package net.nseveryns.agario.net.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * @author nseveryns
 */
public class PipelineInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        pipeline.addLast(new PacketDecoder());
        pipeline.addLast(new PacketEncoder());

        pipeline.addLast(new PacketHandler());
    }
}
