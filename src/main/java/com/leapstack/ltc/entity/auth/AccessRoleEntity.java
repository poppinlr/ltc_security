package com.leapstack.ltc.entity.auth;

import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhuochen on 2017/7/13.
 */
@Data
@Entity
@Table(name = "access_role")
public class AccessRoleEntity implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "access_role_id")
    @Setter(AccessLevel.NONE)
    private Integer accessRoleId;

    @Column(name = "access_id")
    private Integer accessId;

    @Column(name = "role_id")
    private Integer roleId;
}
