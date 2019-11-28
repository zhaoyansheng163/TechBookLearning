http://127.0.0.1:6161/customer/1001  会访问custermer，customer会通过feign调用 account


eureka-config-center  
整合了注册中心和配置中心
http://127.0.0.1:8761/eurekaCenter
http://localhost:8761/config/mysql/dev

参考：https://blog.csdn.net/qq_19404533/article/details/84642093


，可用来代替Chapter-15-eureka-server


Chapter-15-eureka-server eureka-config-center 二选一即可


跟踪中心（会有1分钟左右延迟，因此刚发的交易等一会才会显示）：
http://127.0.0.1:9411/zipkin/



eraka优化：
1、网址链接去掉主机名
2、网址打开时  可以访问  http://192.168.245.1:6161/actuator/info（默认为http://192.168.245.1:6161/info）
3、服务发现
http://192.168.245.1:6060/dept/discovery
4、earaka  status网址调整  参考  https://www.cnblogs.com/li3807/p/7282492.html


actuator 认证参考：
http://www.mamicode.com/info-detail-2375708.html





