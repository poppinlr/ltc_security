package com.leapstack.ltc.entity.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.*;

import javax.jdo.annotations.Join;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"accessEntities","userLoginEntities","companyEntity"})
@Entity
@Table(name = "role")
@EntityListeners(CreateAndModifyListener.class)
public class RoleEntity extends BaseExtendEntity implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    @Setter(AccessLevel.NONE)
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "comment")
    private String comment;

    @JsonBackReference
    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "access_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "access_id", referencedColumnName = "access_id"))
    private List<AccessEntity> accessEntities;

    @OneToMany(mappedBy = "roleEntity")
    @JsonManagedReference
    private List<UserLoginEntity> userLoginEntities;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;
}
