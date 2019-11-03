三个client 即可以单独对外提供服务（Controller可以通过IP端口直接访问），
也可以通过 feign（也是通过服务器名） 或 restTemplate（通过服务名的形式，而不是IP端口）互相调用