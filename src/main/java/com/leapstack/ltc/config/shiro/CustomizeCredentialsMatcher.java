package com.leapstack.ltc.config.shiro;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * Created by zhuochen on 2017/7/6.
 */
@Component
@Log4j
public class CustomizeCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        return this.equals(new String(utoken.getPassword()), info.getCredentials());
    }
}
