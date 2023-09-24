package com.spring.integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MyIntegrationGateway {

    @Gateway(requestChannel = "integration.gateway.channel")
    public String sendData(String city);
}
