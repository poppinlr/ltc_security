package com.leapstack.ltc.config.shiro;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by zhuochen on 2017/7/6.
 */
@Configuration
@Log4j
public class ShiroConfig {

    //TODO error handle
//    @ExceptionHandler(AuthorizationException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public String handleException(AuthorizationException e, Model model) {
//
//        // you could return a 404 here instead (this is how github handles 403, so the user does NOT know there is a
//        // resource at that location)
//        log.debug("AuthorizationException was thrown", e);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("status", HttpStatus.FORBIDDEN.value());
//        map.put("message", "No message available");
//        model.addAttribute("errors", map);
//
//        return "error";
//    }

    @Bean
    protected CustomizeRealm customizeRealm() {
        return new CustomizeRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();

        shiroFilterFactoryBean.setLoginUrl("/loginPage");
        shiroFilterFactoryBean.setUnauthorizedUrl("/loginPage");

        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/auth/*", "authc");

//        shiroFilterFactoryBean.setSuccessUrl("/success");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(customizeRealm());
        return securityManager;
    }

    @Bean
    public CustomizeCredentialsMatcher customizeCredentialsMatcher() {
        return new CustomizeCredentialsMatcher();
    }
}
