package com.example.demo.controller;

import com.example.demo.event.MyApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyansheng
 * @package com.example.demo.controller
 * @date 2019/11/28
 * @description 描述
 */
@RestController
public class TestEventController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/event/alert", method = RequestMethod.GET)
    public String check(@RequestParam(value = "msg") String msg,@RequestParam(value = "type") String type) throws IOException {
        Map map = new HashMap<>();
        map.put("type",type);
        map.put("msg",msg);
        applicationContext.publishEvent(new MyApplicationEvent(map));
        return "OK";

    }

}
