package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhaoyansheng
 * @package com.example.demo.event
 * @date 2019/11/28
 * @description 描述
 */

public class MyApplicationEvent extends ApplicationEvent {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MyApplicationEvent(Object source) {
        super(source);
    }

}