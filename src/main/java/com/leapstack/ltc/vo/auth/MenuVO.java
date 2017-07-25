package com.leapstack.ltc.vo.auth;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
public class MenuVO {

    private Integer menuId;

    private String menuName;

    private Integer parentId;//TODO verify

    private String url;

    private List<AccessVO> accessEntities = new ArrayList<>();
}
