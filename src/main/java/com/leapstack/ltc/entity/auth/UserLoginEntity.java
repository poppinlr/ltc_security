package com.leapstack.ltc.entity.auth;

import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import com.leapstack.ltc.util.SecurityConstant;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_login")
@EntityListeners(CreateAndModifyListener.class)
public class UserLoginEntity extends BaseExtendEntity implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @ColumnTransformer(
            read = "AES_DECRYPT(password, '" + SecurityConstant.ENCRYPTION_KEY + "')",
            write = "AES_ENCRYPT(?, '" + SecurityConstant.ENCRYPTION_KEY + "')")
    private String password;

    @Column(name = "company_id")
    private Integer companyId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

}