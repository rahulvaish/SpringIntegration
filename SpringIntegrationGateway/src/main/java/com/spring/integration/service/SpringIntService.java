package com.spring.integration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class SpringIntService {

    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void receiveMessage(Message<?> message) throws MessagingException {
        System.out.println("######################");
        System.out.println(message);
        System.out.println("######################");
        System.out.println(message.getPayload());
        System.out.println("######################");
        System.out.println(message.getHeaders() );


        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        replyChannel.send(message);


    }
}
