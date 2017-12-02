package org.spring.springcloud.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Customer HelloWorld 案例
 * <p>
 * Created by bysocket on 06/22/17.
 */
@RestController
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private RestTemplate restTemplate; // HTTP 访问操作类


    @RequestMapping("/customer")
    public String customer() {
        String providerMsg = restTemplate.getForEntity("http://PROVIDER-SERVICE/provider",
                String.class).getBody();

        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
    }

    @RequestMapping("/cst/ints")
    public String customerInts() {
        List<Integer> result = restTemplate.getForObject("http://PROVIDER-SERVICE/ints",
                List.class);
        return "Hello,Customer! msg from provider : <br/><br/> " + result;
    }

    @RequestMapping("/reply")
    public String reply() throws JsonProcessingException {
        Reply result = restTemplate.getForObject("http://PROVIDER-SERVICE/reply",
                Reply.class);
        return "Hello,Customer! msg from provider : <br/><br/> " + new ObjectMapper().writeValueAsString(result);
    }
}