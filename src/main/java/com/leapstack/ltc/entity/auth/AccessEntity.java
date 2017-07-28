package com.leapstack.ltc.entity.auth;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"menuEntity", "roleEntities"})
@Entity
@Table(name = "access")
@EntityListeners(CreateAndModifyListener.class)
public class AccessEntity extends BaseExtendEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "access_id")
    @Setter(AccessLevel.NONE)
    private Integer accessId;

    @Column(name = "access_name")
    private String accessName;

    @JoinColumn(name = "menu_id")
    private Integer menuId;

    @ManyToOne//(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false)
    @JsonBackReference
    private MenuEntity menuEntity;

    @ManyToMany(mappedBy = "accessEntities")
    @JsonManagedReference
    private List<RoleEntity> roleEntities;

}
