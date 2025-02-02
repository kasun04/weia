/*
 *
 * Copyright (c) 2016, Kasun Indrasiri  All Rights Reserved.
 *
 */
package kasun.panorama.websockets.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {

    private String websocketPath = "/websocket";

    public WebSocketServerInitializer(String path) {
        websocketPath = path;
        int a = 0;

    }

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerHandler());
    }
}
