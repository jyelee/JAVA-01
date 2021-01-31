package com.jye.week3.gateway.server.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author jye
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {

    public void filter(ChannelHandlerContext ctx, FullHttpRequest fullRequest) {

    }
}
