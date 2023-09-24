package com.spring.integration.config;

import com.spring.integration.model.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.messaging.Message;

@Configuration
public class BeanConfig {

    @Bean
    @Filter(inputChannel = "integration.gateway.input.channel")
    public MessageFilter filter(){
        MessageFilter messageFilter = new MessageFilter(new MessageSelector() {
            @Override
            public boolean accept(Message<?> message) {
                Address a = (Address) message.getPayload();
                if("Montreal".equalsIgnoreCase(a.getCity())){
                    return true;
                }
                return false;
            }
        });
        messageFilter.setOutputChannelName("integration.gateway.output.channel");
        return messageFilter;
    }
}
