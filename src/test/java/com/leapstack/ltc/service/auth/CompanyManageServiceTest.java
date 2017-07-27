//package com.leapstack.ltc.service.auth;
//
//import com.leapstack.ltc.Application;
//import com.leapstack.ltc.config.shiro.CustomizeRealm;
//import com.leapstack.ltc.entity.auth.CompanyEntity;
//import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
//import com.leapstack.ltc.vo.auth.CompanyVO;
//import com.leapstack.ltc.vo.web.LoginInfo;
//import lombok.extern.log4j.Log4j;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.apache.shiro.SecurityUtils.setSecurityManager;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@Log4j
//public class CompanyManageServiceTest {
//
//    @Autowired
//    private CustomizeRealm customizeRealm;
//
//    @Autowired
//    private AuthService authService;
//
//    @Autowired
//    private CompanyManageService companyManageService;
//
//    @Autowired
//    private CompanyEntityRepository companyEntityRepository;
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
//        CompanyVO companyVO = new CompanyVO();
//        companyVO.setCompanyName("中支公司");
//        companyVO.setLevel(1);
//        companyVO.setParentId(1);
//        companyManageService.saveCompany(companyVO);
//    }
//
//    @Test
//    public void update(){
//        CompanyEntity entity = companyEntityRepository.findByCompanyName("中支公司");
//        CompanyVO companyVO = new CompanyVO();
//        BeanUtils.copyProperties(entity, companyVO);
//        companyVO.setCompanyName("中支公司 改");
//        companyManageService.updateCompany(companyVO);
//    }
//
//    @Test
//    public void delete(){
//        CompanyEntity entity = companyEntityRepository.findByCompanyName("中支公司 改");
//        companyManageService.deleteCompany(entity.getCompanyId());
//    }
//}
