//package com.leapstack.ltc.service.auth;
//
//import com.leapstack.ltc.Application;
//import com.leapstack.ltc.config.shiro.CustomizeRealm;
//import com.leapstack.ltc.vo.auth.MenuVO;
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
//import java.util.List;
//
//import static org.apache.shiro.SecurityUtils.setSecurityManager;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@Log4j
//public class MenuServiceTest {
//
//    @Autowired
//    private CustomizeRealm customizeRealm;
//
//    @Autowired
//    private AuthService authService;
//
//    @Autowired
//    private MenuService menuService;
//
//    @Before
//    public void init(){
//        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
//        securityManager.setRealm(customizeRealm);
//        securityManager.setSessionManager(new DefaultWebSessionManager());
//        setSecurityManager(securityManager);
//        authService.login(new LoginInfo("admin", "admin"));
//    }
//
//    @Test
//    public void menu(){
//        List<MenuVO> menuVOS =  menuService.getMenuWithAccessList();
//    }
//
//}
