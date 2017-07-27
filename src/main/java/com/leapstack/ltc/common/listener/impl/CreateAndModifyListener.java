package com.leapstack.ltc.common.listener.impl;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import com.leapstack.ltc.util.SecurityConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/20.
 */
public class CreateAndModifyListener {

    @PrePersist
    public void setCreatedAtAndCreatedBy(BaseExtendEntity entity) {
        entity.setCreatedAt(new Date());


        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() == null) {
            entity.setCreatedBy(SecurityConstant.ADMIN_ID);
        } else {
            entity.setCreatedBy(((UserLoginEntity) subject.getPrincipal()).getUserId());
        }

        setModifiedAtAndModifiedBy(entity);
    }

    @PreUpdate
//    @PrePersist
    public void setModifiedAtAndModifiedBy(BaseExtendEntity entity) {
        entity.setModifiedAt(new Date());

        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() == null) {
            entity.setModifiedBy(SecurityConstant.ADMIN_ID);
        } else {
            entity.setModifiedBy(((UserLoginEntity) subject.getPrincipal()).getUserId());
        }
    }
}
