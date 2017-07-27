package com.leapstack.ltc.vo.web;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PageResponse<T> implements Serializable {

    private Integer current;//当前页数
    private Integer pageSize;//每页显示多少元素
    private Integer totalPages;//一共有多少页
    private Long total;//一共有多少元素

    private List<T> list;

    public PageResponse(Page<T> page) {
        this.current = page.getNumber();
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.total = page.getTotalElements();
        this.list = page.getContent();
    }

    public PageResponse(Page page, List<T> list) {
        this.current = page.getNumber();
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.total = page.getTotalElements();
        this.list = list;
    }
}