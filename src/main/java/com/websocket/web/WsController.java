package com.websocket.web;

import com.websocket.domain.WiselyMessage;
import com.websocket.domain.WiselyResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WsController {
    @MessageMapping("/welcome")//当浏览器向服务端发送请求时，通过@messageMapping映射到Welcome这个地址，类似于@RequestMapping
    @SendTo("/topic/getResponse")//当服务端有消息是，会对订阅了@SendTo中的路径的浏览器发送消息
    public WiselyResponse say(WiselyMessage message)throws Exception{
        Thread.sleep(3000);
        return new WiselyResponse("Welcome, " + message.getName() + " !" );
    }
}
