package com.leapstack.ltc.entity.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import com.leapstack.ltc.util.SecurityConstant;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"companyEntity", "roleEntity"})
@Entity
@Table(name = "user_login")
@EntityListeners(CreateAndModifyListener.class)
public class UserLoginEntity extends BaseExtendEntity implements Serializable {

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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private CompanyEntity companyEntity;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonBackReference
    private RoleEntity roleEntity;

}