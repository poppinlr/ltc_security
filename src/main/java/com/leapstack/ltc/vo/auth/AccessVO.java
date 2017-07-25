package com.leapstack.ltc.vo.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;

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
