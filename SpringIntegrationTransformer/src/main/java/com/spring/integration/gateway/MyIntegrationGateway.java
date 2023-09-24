package com.spring.integration.gateway;

import com.spring.integration.model.Address;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MyIntegrationGateway {

    @Gateway(requestChannel = "integration.address.input.channel")
    public String sendData(Address address);
}
