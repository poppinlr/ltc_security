package com.leapstack.ltc.entity.auth;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "company")
@ToString(exclude = "roleEntities")
@EntityListeners(CreateAndModifyListener.class)
public class CompanyEntity extends BaseExtendEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    @Setter(AccessLevel.NONE)
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "level")
    private Integer level;

    @Column(name = "parent_id")
    private Integer parentId;

    @OneToMany(mappedBy = "companyEntity")
    @JsonManagedReference
    private List<RoleEntity> roleEntities;

}
