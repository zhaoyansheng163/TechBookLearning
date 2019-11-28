package com.example.demo.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhaoyansheng
 * @package com.example.demo.event
 * @date 2019/11/28
 * @description 描述
 */
@Component
public class EventHandle {

    /**
     * 维护一个枚举类，存储所有支持的触发事件和对应的描述，提供查询功能供配置时使用
     * 维护一个枚举类，存储所有可被调用的方法，比如 “设置空调为20度”
     * 定义一个表存储触发事件和被调用的方法之间的对应关系
     */
    @EventListener
    public void event(MyApplicationEvent event) {
        System.out.println("EventHandle 接受到事件 : "  + event.getClass()  + " msg:"+ event.getSource());
        Map map = (Map)event.getSource();
        switch (map.get("type").toString()){
            case "error":
                System.out.println(" this is an error msg");
                break;
            case "info":
                System.out.println(" this is an info msg" +" --------------");
                break;
            default:
                System.out.println(" default msg" +" #################");
                break;
        }
    }
}
