package com.leapstack.ltc.entity.auth;

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
@ToString(exclude = "accessEntities")
@Entity
@Table(name = "menu")
@EntityListeners(CreateAndModifyListener.class)
public class MenuEntity extends BaseExtendEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    @Setter(AccessLevel.NONE)
    private Integer menuId;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "parent_id")
    private Integer parentId;//TODO verify

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icon;

    @OneToMany(mappedBy = "menuEntity")
    @JsonManagedReference
    private List<AccessEntity> accessEntities;
}
