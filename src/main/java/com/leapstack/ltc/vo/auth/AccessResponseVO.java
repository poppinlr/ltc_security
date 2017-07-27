package com.leapstack.ltc.vo.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessResponseVO {

    private Integer accessId;

    private String accessName;

    public AccessResponseVO(AccessEntity entity) {
        this.accessId = entity.getAccessId();
        this.accessName = entity.getAccessName();
    }
}
