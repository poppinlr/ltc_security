package com.leapstack.ltc.vo.web;

import lombok.Data;

@Data
public class SortRequest {
    private boolean desc = true;
    private String sort;
}
