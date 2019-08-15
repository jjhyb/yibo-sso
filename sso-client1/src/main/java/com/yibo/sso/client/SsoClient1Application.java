package com.yibo.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: huangyibo
 * @Date: 2019/8/13 22:16
 * @Description:
 */

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SsoClient1Application {

    public static void main(String[] args) {

        SpringApplication.run(SsoClient1Application.class,args);
    }

    /**
     * 将当前系统session中放的那个Authentication取出来，转成json返回
     * 这样便可看到当前系统登录的用户信息
     * @param user
     * @return
     */
    @GetMapping("/user")
    public Authentication user(Authentication user){
        return user;
    }
}
