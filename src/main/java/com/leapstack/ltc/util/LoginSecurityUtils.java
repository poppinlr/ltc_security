package com.leapstack.ltc.util;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import org.apache.shiro.SecurityUtils;

/**
 * Created by zhuochen on 2017/7/19.
 */
public class LoginSecurityUtils extends SecurityUtils {

    public static UserLoginEntity getUserLoginEntity() {
        return (UserLoginEntity) getSubject().getPrincipal();
    }
}
