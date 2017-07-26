package com.leapstack.ltc.vo.web;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResponse<T> implements Serializable{

    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Integer totalElements;

    private List<T> content;
}