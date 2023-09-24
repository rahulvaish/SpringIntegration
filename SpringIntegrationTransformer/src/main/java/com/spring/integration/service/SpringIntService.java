package com.spring.integration.service;

import com.spring.integration.model.Address;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class SpringIntService {

    @ServiceActivator(inputChannel = "integration.address.output.object2json.channel", outputChannel = "integration.address.input.json2object.channel")
    public Message<?> receiveMessageOne(Message<?> message) throws MessagingException {
        System.out.println("###########################");
        System.out.println(message);
        System.out.println("########## O2J ############");
        System.out.println(message.getPayload());
        return message;
    }

    @ServiceActivator(inputChannel = "integration.address.output.json2object.channel")
    public void receiveMessageTwo(Message<?> message) throws MessagingException {
        System.out.println("###########################");
        System.out.println(message);
        System.out.println("######### J2O #############");
        System.out.println(message.getPayload());

        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        Address address = (Address)message.getPayload();
        Message<?> newMessage = MessageBuilder.withPayload(address.toString()).build();
        replyChannel.send(newMessage);
    }
}
