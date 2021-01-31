package com.jye.week3.gateway.server.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author jye
 */
public interface HttpRequestFilter {

    /**
     * @param ctx
     * @param fullRequest
     */
    void filter(ChannelHandlerContext ctx, FullHttpRequest fullRequest);
}
