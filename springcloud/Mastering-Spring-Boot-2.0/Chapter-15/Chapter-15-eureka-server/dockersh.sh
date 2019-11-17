docker build  -t spring-boot-eureka:1.0.1  .
docker run -p 8761:8761 spring-boot-eureka:1.0.1
