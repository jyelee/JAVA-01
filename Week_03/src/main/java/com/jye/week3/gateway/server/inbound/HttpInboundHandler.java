package com.jye.week3.gateway.server.inbound;

import com.jye.week3.gateway.server.filter.HttpRequestFilter;
import com.jye.week3.gateway.server.outbound.HttpOutBoundHandler;
import com.jye.week3.gateway.server.outbound.HttpClient;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private HttpOutBoundHandler handler;
    private HttpRequestFilter filter;

    public HttpInboundHandler(List<String> proxyServer,
        HttpRequestFilter filter) {
        this.proxyServer = proxyServer;
        this.filter = filter;
        this.handler = new HttpClient(this.proxyServer);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            this.filter.filter(ctx, fullRequest);
            handler.handle(ctx, fullRequest);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
