package com.leapstack.ltc.service.auth;

import com.google.common.collect.Lists;
import com.leapstack.ltc.Application;
import com.leapstack.ltc.config.shiro.CustomizeRealm;
import com.leapstack.ltc.entity.auth.*;
import com.leapstack.ltc.repository.auth.*;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by zhuochen on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Log4j
public class TestDataInit {

    @Autowired
    private MenuEntityRepository menuEntityRepository;

    @Autowired
    private AccessEntityRepository accessEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private UserLoginEntityRepository userEntityRepository;

    @Autowired
    private CompanyEntityRepository companyEntityRepository;


    /**
     * menu1 -access1,access2
     * menu2 -access3,access4
     *
     * user1 -access1,access2,access3,access4
     * user2 -access1,access3
     * user3 -access1,access2
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void initData(){
        AccessEntity accessEntity1 = new AccessEntity();
        accessEntity1.setAccessName("access1");
        accessEntityRepository.save(accessEntity1);

        AccessEntity accessEntity2 = new AccessEntity();
        accessEntity2.setAccessName("access2");
        accessEntityRepository.save(accessEntity2);

        AccessEntity accessEntity3 = new AccessEntity();
        accessEntity3.setAccessName("access3");
        accessEntityRepository.save(accessEntity3);

        AccessEntity accessEntity4 = new AccessEntity();
        accessEntity4.setAccessName("access4");
        accessEntityRepository.save(accessEntity4);

        MenuEntity menuEntity1 = new MenuEntity();
        menuEntity1.setMenuName("menu1");
        menuEntity1.setUrl("/menu1");
        menuEntity1.setAccessEntities(accessEntityRepository.findByAccessIdIn(Lists.newArrayList(1,2)));
        menuEntityRepository.save(menuEntity1);

        MenuEntity menuEntity2 = new MenuEntity();
        menuEntity2.setMenuName("menu2");
        menuEntity2.setUrl("/menu2");
        menuEntity2.setAccessEntities(accessEntityRepository.findByAccessIdIn(Lists.newArrayList(3,4)));
        menuEntityRepository.save(menuEntity2);

        RoleEntity roleEntity1 = new RoleEntity();
        roleEntity1.setRoleName("role1");
        roleEntity1.setAccessEntities(accessEntityRepository.findAll());
        roleEntityRepository.save(roleEntity1);

        RoleEntity roleEntity2 = new RoleEntity();
        roleEntity2.setRoleName("role2");
        roleEntity2.setAccessEntities(accessEntityRepository.findByAccessIdIn(Lists.newArrayList(1,3)));
        roleEntityRepository.save(roleEntity2);

        RoleEntity roleEntity3 = new RoleEntity();
        roleEntity3.setRoleName("role3");
        roleEntity3.setAccessEntities(accessEntityRepository.findByAccessIdIn(Lists.newArrayList(1,2)));
        roleEntityRepository.save(roleEntity3);

        UserLoginEntity userLoginEntity1 = new UserLoginEntity();
        userLoginEntity1.setUsername("user1");
        userLoginEntity1.setPassword("pwd1");
        userLoginEntity1.setRoleEntity(roleEntityRepository.findOne(1));


        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName("comp1");
        companyEntity.setLevel(1);
        companyEntityRepository.save(companyEntity);
        CompanyEntity companyEntity1_1 = new CompanyEntity();
        companyEntity1_1.setCompanyName("comp1.1");
        companyEntity1_1.setLevel(2);
        companyEntity1_1.setParentId(1);
        companyEntityRepository.save(companyEntity1_1);
        CompanyEntity companyEntity1_1_1 = new CompanyEntity();
        companyEntity1_1_1.setCompanyName("comp1.1.1");
        companyEntity1_1_1.setLevel(3);
        companyEntity1_1_1.setParentId(2);
        companyEntityRepository.save(companyEntity1_1_1);
        CompanyEntity companyEntity1_2 = new CompanyEntity();
        companyEntity1_2.setCompanyName("comp1.2");
        companyEntity1_2.setLevel(2);
        companyEntity1_2.setParentId(1);
        companyEntityRepository.save(companyEntity1_2);


        userLoginEntity1.setCompanyEntity(companyEntity);
        userEntityRepository.save(userLoginEntity1);

//        UserLoginEntity userLoginEntity2 = new UserLoginEntity();
//        userLoginEntity2.setUsername("user2");
//        userLoginEntity2.setPassword("pwd2");
//        userLoginEntity2.setRoleEntity(roleEntityRepository.findOne(2));
//        userEntityRepository.save(userLoginEntity2);
//
//        UserLoginEntity userLoginEntity3 = new UserLoginEntity();
//        userLoginEntity3.setUsername("user3");
//        userLoginEntity3.setPassword("pwd3");
//        userLoginEntity3.setRoleEntity(roleEntityRepository.findOne(3));
//        userEntityRepository.save(userLoginEntity3);

    }

}
