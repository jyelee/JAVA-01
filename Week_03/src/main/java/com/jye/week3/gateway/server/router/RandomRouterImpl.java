package com.jye.week3.gateway.server.router;

import java.util.List;
import java.util.Random;

/**
 * @author jye
 */
public class RandomRouterImpl implements Router {

    /**
     * 从 backend 找出一个实例
     *
     * @param backend
     * @return
     */
    @Override
    public String route(List<String> backend) throws Exception {
        if (backend == null || backend.isEmpty()) {
            throw new Exception("invalid backend");
        }
        Random random = new Random();
        return backend.get(random.nextInt(backend.size()));
    }
}
