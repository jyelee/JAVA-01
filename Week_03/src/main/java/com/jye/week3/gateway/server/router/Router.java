package com.jye.week3.gateway.server.router;

import java.util.List;

/**
 * @author jye
 * router 接口, 从后端实例中找出一个
 */
public interface Router {

    /**
     * 从 backend 找出一个实例
     * @param backend
     * @return
     */
    String route(List<String> backend) throws Exception;
}
