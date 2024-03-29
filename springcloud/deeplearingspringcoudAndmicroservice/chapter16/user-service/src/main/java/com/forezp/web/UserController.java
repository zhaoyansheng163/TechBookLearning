package com.forezp.web;

import com.forezp.annotation.SysLogger;
import com.forezp.config.RabbitConfig;
import com.forezp.dto.RespDTO;
import com.forezp.entity.User;
import com.forezp.service.UserService;
import com.forezp.util.BPwdEncoderUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fangzhipeng on 2017/7/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册", notes = "username和password为必选项")
    @PostMapping("/registry")
    @SysLogger("registry")
    public User createUser(@RequestBody User user){
        //参数判读省略,判读该用户在数据库是否已经存在省略
        String entryPassword= BPwdEncoderUtils.BCryptPassword(user.getPassword());
        user.setPassword(entryPassword);
        return userService.createUser(user);
    }

    @ApiOperation(value = "登录", notes = "username和password为必选项")
    @PostMapping("/login")
    @SysLogger("login")
    public RespDTO login(@RequestParam String username , @RequestParam String password){
        //参数判读省略
      return   userService.login(username,password);
    }

    @ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
    @PostMapping("/info/{username}")
    //@PreAuthorize("hasRole('USER')")
    //@SysLogger("getUserInfo")
   // @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public RespDTO getUserInfo(@PathVariable("username") String username){
        //参数判读省略
        User user=  userService.getUserInfo(username);
        return RespDTO.onSuc(user);
    }

    @GetMapping("/getinfo")
    public String getinfo(@RequestParam String username){
        log.info("-----------------------------Enter getinfo" );
        log.info("-----------------------------Enter getinfo:" + username );

        User user=  userService.getUserInfo(username);
        return user.toString();
    }
    @GetMapping("/test")
    public String test(){
        log.info("-----------------------------Enter test" );

        return "mytest";
    }

    @GetMapping("/test1")
    public String test1(@RequestParam String username){
        log.info("-----------------------------Enter test1" );

        return "mytest:"+username;
    }
    @GetMapping("/test2")
    public String test2(@RequestParam String username){
        log.info("-----------------------------Enter test2" );
        User user=  userService.getUserInfo(username);
        return user.toString();
    }
    @GetMapping("/myinfo")
    public String myinfo(@RequestParam String username){
        log.info("-----------------------------Enter myinfo" );
        User user=  userService.getUserInfo(username);
        return user.toString();
    }

}
