package org.spring.springcloud.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by cqs on 2017/11/30.
 */
@RestController
public class HelloController {


    @GetMapping("/ints")
    public List<Integer> rand() {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100));
        }
        return list;
    }

    @GetMapping("/reply")
    public Reply reply() {
        Reply re = new Reply();
        re.setCommentId(10L);
        re.setcTime(new Date());
        re.setContent("Hello World:" + LocalDateTime.now());
        return re;
    }

    public static void main(String[] args) throws JsonProcessingException {
        HelloController controller = new HelloController();
        ObjectMapper mapper = new ObjectMapper();
        final String s = mapper.writeValueAsString(controller.rand());

        System.out.println(mapper.writeValueAsString(controller.reply()));
    }

}
