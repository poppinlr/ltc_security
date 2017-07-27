package com.leapstack.ltc.vo.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import com.leapstack.ltc.entity.auth.MenuEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
public class MenuResponseVO {

    private Integer menuId;

    private String menuName;

    private Integer parentId;//TODO verify

    private String url;

    private List<AccessResponseVO> accessEntities = new ArrayList<>();

    public MenuResponseVO(MenuEntity entity) {
        this.menuId = entity.getMenuId();
        this.menuName = entity.getMenuName();
        this.parentId = entity.getParentId();
        this.url = entity.getUrl();

        for (AccessEntity accessEntity : entity.getAccessEntities()) {
            this.accessEntities.add(new AccessResponseVO(accessEntity));
        }
    }
}
