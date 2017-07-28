package com.leapstack.ltc.util;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.vo.web.SortRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by zhuochen on 2017/7/19.
 */
public class UtilService extends SecurityUtils {

    public static UserLoginEntity getUserLoginEntity() {
        if (getSubject().getPrincipal() == null) {
            return new UserLoginEntity();
        } else {
            return (UserLoginEntity) getSubject().getPrincipal();
        }
    }

    public static PageRequest getPageRequestWithSorting(PageRequest request, SortRequest sortRequest) {
        return new PageRequest(request.getPageNumber(), request.getPageSize()
                , sortRequest.isDesc() ? Sort.Direction.DESC : Sort.Direction.ASC, sortRequest.getSort());
    }
}
