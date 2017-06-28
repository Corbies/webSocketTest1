package com.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker//通过这个注解使用STOMP协议来传输基于代理 message broker 的消息，这时控制器支持使用@messageMapping 就像使用@RequestMapping一样
public class WebsockeConfig extends AbstractWebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {//注册STOMP协议节点，并映射的指定的URl
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();//注册一个Stomp的endponint,并使用SockJs协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {//配置消息代理
        registry.enableSimpleBroker("/topic");//广播式应配置一个topic消息代理
    }

}
