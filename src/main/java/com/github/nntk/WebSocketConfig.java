package com.github.nntk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/logSocket")
                .setAllowedOrigins("*")
                .withSockJS();
    }


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Value("${local.server.port:8080}")
    private String port;

    @PostConstruct
    public void pushLogger() {

        log.info("Welcome use loges,you can visit this url to open web quickly: " + getUrl());


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        LoggerMessage log = LoggerQueue.getInstance().poll();
                        if (log != null) {
                            if (messagingTemplate != null)
                                messagingTemplate.convertAndSend("/topic/pullLogger", log);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        executorService.submit(runnable);
        executorService.submit(runnable);
    }


    public String getUrl() {
        InetAddress localHost = null;
        try {
            localHost = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
        }
        String ip = localHost.getHostAddress();

        return "http://" + ip + ":" + port + "/logos/index.html";
    }
}
