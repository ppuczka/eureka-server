package com.microservices.lab.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Controller
public class ConcatController {

    @Autowired
    DiscoveryClient client;
    
    @GetMapping("/concat")
    public @ResponseBody String getSentence() {
        return
                getWord("EUREKA-CLIENT-1") + " "
                        + getWord("EUREKA-CLIENT-2") + " "
                        + getWord("EUREKA-CLIENT-3") + " "
                        + getWord("EUREKA-CLIENT-4");
    }

    public String getWord(String service) {
        
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
}
