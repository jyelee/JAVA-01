package com.jye.week3.gateway.server.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author jye
 */
public interface HttpOutBoundHandler {

    /**
     * HttpOutBoundHandler
     * @param ctx
     * @param request
     */
    void handle(final ChannelHandlerContext ctx, final FullHttpRequest request);

}
