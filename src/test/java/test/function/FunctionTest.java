package test.function;

import com.leapstack.ltc.Application;
import com.leapstack.ltc.config.shiro.CustomizeRealm;
import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import com.leapstack.ltc.service.auth.CompanyManageService;
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

import static org.apache.shiro.SecurityUtils.setSecurityManager;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Log4j
public class FunctionTest {

    @Autowired
    private CustomizeRealm customizeRealm;

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    @Autowired
    private CompanyManageService companyManageService;

    @Before
    public void init(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(customizeRealm);
        securityManager.setSessionManager(new DefaultWebSessionManager());
        setSecurityManager(securityManager);
        SecurityUtils.getSubject().login(new UsernamePasswordToken("admin","admin"));
    }

    @Test
    public void test(){
//        UserLoginEntity userLoginEntity = (UserLoginEntity) SecurityUtils.getSubject().getPrincipal();
//        CompanyEntity userCompany = companyEntityRepository.findOne(userLoginEntity.getCompanyEntity().getCompanyId());
        companyManageService.getCompanyVOList();
    }
}
