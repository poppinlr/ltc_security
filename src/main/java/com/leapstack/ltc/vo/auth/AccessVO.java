package com.leapstack.ltc.vo.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessVO {

    private Integer accessId;

    private String accessName;
}
