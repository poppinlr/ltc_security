package com.leapstack.ltc;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EnableJpaRepositories
@SpringBootApplication
public class Application {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory JPAQueryFactory(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return queryFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
