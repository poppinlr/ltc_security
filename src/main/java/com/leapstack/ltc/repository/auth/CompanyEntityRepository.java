package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyEntityRepository extends JpaRepository<CompanyEntity, Integer> {

    
    List<CompanyEntity> findByParentId(Integer id);

    CompanyEntity findByCompanyName(String name);
}
