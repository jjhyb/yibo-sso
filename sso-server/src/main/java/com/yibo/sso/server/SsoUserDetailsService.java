package com.yibo.sso.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author: huangyibo
 * @Date: 2019/8/14 18:08
 * @Description:
 */

@Component
public class SsoUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(SsoUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    //这里可以注入dao层进行数据库查询，查询出用户信息进行校验


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("数据库密码是：123456");
        return new User(username,passwordEncoder.encode("123456"),
                /*//账户是否可用，       账户是否过期，         密码是否过期，             账户是否被冻结
                true,true,true,true,*/
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
