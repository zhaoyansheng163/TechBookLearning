Chapter-12-notification-service-docker  不要了，没调试

调试步骤
先mvn编译每个微服务，然后使用dockershell生成docker镜像
然后在 docker-compose 目录执行 docker-compose up -d  即可一次启动多个容器

http://127.0.0.1:6161/customer/1001  会访问custermer，customer会通过feign调用 account



