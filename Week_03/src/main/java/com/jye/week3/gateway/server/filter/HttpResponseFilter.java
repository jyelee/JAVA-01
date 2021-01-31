package com.jye.week3.gateway.server.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author jye
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}
