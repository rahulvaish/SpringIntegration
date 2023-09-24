package com.spring.integration.contrller;

import com.spring.integration.gateway.MyIntegrationGateway;
import com.spring.integration.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyIntegrationController {

    @Autowired
    MyIntegrationGateway myIntegrationGateway;

    @ResponseBody
    @PostMapping("/sendData")
    public void sendData(@RequestBody Address address){
        myIntegrationGateway.sendData(address);
    }

}
