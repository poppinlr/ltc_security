package com.leapstack.ltc.vo.web;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhuochen on 2017/7/17.
 */
@Data
@NoArgsConstructor
public class ResponseMessage {
    private Boolean success = false;
    private String message;
//    private Object response;
}
