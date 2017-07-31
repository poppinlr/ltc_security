package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.Application;
import com.leapstack.ltc.config.shiro.CustomizeRealm;
import com.leapstack.ltc.entity.auth.AccessEntity;
import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.entity.auth.RoleEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.vo.web.LoginInfo;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.ldap.PagedResultsControl;

import java.util.List;

import static org.apache.shiro.SecurityUtils.setSecurityManager;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhuochen on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Log4j
public class AuthServiceTest {

    @Autowired
    private CustomizeRealm customizeRealm;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserLoginEntityRepository repository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Before
    public void init(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(customizeRealm);
        securityManager.setSessionManager(new DefaultWebSessionManager());
        setSecurityManager(securityManager);
    }

    @Test
    public void login(){
//        assertEquals(authService.login(new LoginInfo("user1", "pwd1")).getSuccess(), true);
//        assertEquals(authService.login(new LoginInfo("user1", "pwd2")).getSuccess(), false);

    }

    @Test
    public void getMenuWithAccessList(){
//        SecurityUtils.getSubject().login(new UsernamePasswordToken("user1","pwd1"));
//        log.info(authService.getMenuWithAccessList().size());
//        assertEquals(authService.getMenuWithAccessList().size(), 2);
//
//
//        SecurityUtils.getSubject().login(new UsernamePasswordToken("user2","pwd2"));
//        log.info(authService.getMenuWithAccessList().size());
//        assertEquals(authService.getMenuWithAccessList().size(), 2);
//
//        SecurityUtils.getSubject().login(new UsernamePasswordToken("user3","pwd3"));
//        log.info(authService.getMenuWithAccessList().size());
//        assertEquals(authService.getMenuWithAccessList().size(), 1);
    }

    @Test
    public void getRoleNamesByUserId(){
//        assertEquals(authService.getRoleNamesByUserId(1).size(), 1);
//        assertEquals(authService.getRoleNamesByUserId(2).size(), 1);
//        assertEquals(authService.getRoleNamesByUserId(3).size(), 1);
    }

    @Test
    public void getRole(){
//        RoleEntity roleEntity = roleEntityRepository.findByRoleName("role1");
//        List<AccessEntity> accessEntities = roleEntity.getAccessEntities();
//        CompanyEntity companyEntity = roleEntity.getCompanyEntity();
//        List<UserLoginEntity> loginEntities = roleEntity.getUserLoginEntities();
//        UserLoginEntity entity = repository.findByUsername("user1");
    }
}
