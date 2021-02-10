package com.jye.week3.gateway;

import com.jye.week3.gateway.server.inbound.HttpInboundServer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jye
 */
public class GatewayBootstrap {
    public static void main(String []args) {
        List<String> backend = new ArrayList<>();
        backend.add("http://127.0.0.8080");
        HttpInboundServer server = new HttpInboundServer(5050, backend);
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
