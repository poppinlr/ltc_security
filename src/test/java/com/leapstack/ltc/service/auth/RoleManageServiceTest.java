//package com.leapstack.ltc.service.auth;
//
//import com.leapstack.ltc.Application;
//import com.leapstack.ltc.config.shiro.CustomizeRealm;
//import com.leapstack.ltc.entity.auth.QRoleEntity;
//import com.leapstack.ltc.entity.auth.RoleEntity;
//import com.leapstack.ltc.repository.auth.RoleEntityRepository;
//import com.leapstack.ltc.vo.web.LoginInfo;
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import lombok.extern.log4j.Log4j;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
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
//public class RoleManageServiceTest {
//
//    @Autowired
//    private CustomizeRealm customizeRealm;
//
//    @Autowired
//    private AuthService authService;
//
//    @Autowired
//    private RoleEntityRepository roleEntityRepository;
//
//    @Autowired
//    private JPAQueryFactory jpaQueryFactory;
//
//    private static QRoleEntity qRoleEntity = QRoleEntity.roleEntity;
//
//    @Before
//    public void init() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(customizeRealm);
//        securityManager.setSessionManager(new DefaultWebSessionManager());
//        setSecurityManager(securityManager);
//
//        authService.login(new LoginInfo("admin", "admin"));
//    }
//
//    @Test
//    public void test() {
//        BooleanBuilder when = new BooleanBuilder(qRoleEntity.roleId.eq(1));
//        Page<RoleEntity> page = roleEntityRepository.findAll(when, new PageRequest(0, 10, Sort.Direction.DESC, "companyId"));
//    }
//
//}
