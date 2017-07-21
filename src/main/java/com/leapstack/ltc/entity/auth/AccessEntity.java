package com.leapstack.ltc.entity.auth;

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
@ToString(exclude = {"menuEntity","roleEntities"})
@Entity
@Table(name = "access")
@EntityListeners(CreateAndModifyListener.class)
public class AccessEntity extends BaseExtendEntity implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "access_id")
    @Setter(AccessLevel.NONE)
    private Integer accessId;

    @Column(name = "access_name")
    private String accessName;

    @ManyToOne//(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;

    @ManyToMany(mappedBy = "accessEntities")
    private List<RoleEntity> roleEntities;

}
