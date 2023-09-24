package com.spring.integration.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.integration.model.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

@Configuration
public class BeanConfig {

    @Bean
    @Transformer(inputChannel = "integration.address.input.channel", outputChannel = "integration.address.output.object2json.channel" )
    public ObjectToJsonTransformer objectToJsonTransformer(){
        return new ObjectToJsonTransformer(getMapper());
    }


    @Bean
    public Jackson2JsonObjectMapper getMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(objectMapper);
    }


    @Bean
    @Transformer(inputChannel = "integration.address.input.json2object.channel", outputChannel = "integration.address.output.json2object.channel" )
    public JsonToObjectTransformer jsonToObjectTransformer(){
        return new JsonToObjectTransformer(Address.class);
    }

}
