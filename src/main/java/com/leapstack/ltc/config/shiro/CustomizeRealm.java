package com.leapstack.ltc.config.shiro;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.service.auth.AuthService;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/6.
 */
@Log4j
public class CustomizeRealm extends AuthorizingRealm {

    @Autowired
    private UserLoginEntityRepository userLoginEntityRepository;

    @Autowired
    private AuthService authService;

    public CustomizeRealm() {
        setName("CustomizeRealm");
        setCredentialsMatcher(new CustomizeCredentialsMatcher());
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

        UserLoginEntity userLoginEntity = userLoginEntityRepository.findByUsername(token.getUsername());
        if (userLoginEntity != null) {
            return new SimpleAuthenticationInfo(userLoginEntity, userLoginEntity.getPassword(), getName());
        } else {
            return null;
        }
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        UserLoginEntity userLoginEntity = (UserLoginEntity) principals.getPrimaryPrincipal();
        List<String> roleList = authService.getRoleNamesByUserId(userLoginEntity.getUserId());
        if(roleList != null && roleList.size() > 0){
            authorizationInfo.setRoles(new HashSet<>(roleList));
        }
//
//        Set<String> permissionSet = new HashSet<>();
//        permissionSet.add("guest");
//        authorizationInfo.setStringPermissions(permissionSet);

        return new SimpleAuthorizationInfo();
    }
}
