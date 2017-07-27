//package com.leapstack.ltc.service.auth;
//
//import com.leapstack.ltc.Application;
//import com.leapstack.ltc.config.shiro.CustomizeRealm;
//import com.leapstack.ltc.entity.auth.UserLoginEntity;
//import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
//import com.leapstack.ltc.repository.auth.RoleEntityRepository;
//import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
//import com.leapstack.ltc.vo.web.LoginInfo;
//import lombok.extern.log4j.Log4j;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.apache.shiro.SecurityUtils.setSecurityManager;
//
///**
// * Created by zhuochen on 2017/7/21.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@Log4j
//public class UserManageServiceTest {
//
//    @Autowired
//    private CustomizeRealm customizeRealm;
//
//    @Autowired
//    private AuthService authService;
//
//    @Autowired
//    private UserManageService userManageService;
//
//    @Autowired
//    private CompanyEntityRepository companyEntityRepository;
//
//    @Autowired
//    private UserLoginEntityRepository userLoginEntityRepository;
//
//
//    @Before
//    public void init(){
//        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
//        securityManager.setRealm(customizeRealm);
//        securityManager.setSessionManager(new DefaultWebSessionManager());
//        setSecurityManager(securityManager);
//
//        authService.login(new LoginInfo("admin", "admin"));
//    }
//
//    @Test
//    public void create(){
//        UserLoginEntity userLoginEntity = new UserLoginEntity();
//        userLoginEntity.setUsername("user1");
//        userLoginEntity.setPassword("pwd1");
//        userLoginEntity.setCompanyEntity(companyEntityRepository.findOne(1));
////        userManageService.createUser(1)
//    }
//}
