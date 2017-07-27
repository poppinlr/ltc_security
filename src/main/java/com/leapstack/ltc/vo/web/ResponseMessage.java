package com.leapstack.ltc.vo.web;

import lombok.Data;

@Data
public class ResponseMessage {
    private boolean success = false;
    private String message;

}
