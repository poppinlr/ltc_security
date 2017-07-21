//package com.leapstack.ltc.entity;
//
//import com.leapstack.ltc.common.listener.Creatable;
//import com.leapstack.ltc.common.listener.impl.CreatedAtListener;
//import com.leapstack.ltc.common.listener.Modifiable;
//import com.leapstack.ltc.util.DatabaseConstant;
//import com.leapstack.ltc.common.listener.impl.ModifiedAtListener;
//import lombok.Data;
//import org.hibernate.annotations.ColumnTransformer;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * Created by zhuochen on 2017/7/4.
// */
//@Entity
//@EntityListeners({ModifiedAtListener.class, CreatedAtListener.class})
//@Table(name = "user_role")
//@Data
//public class UserRoleEntity extends BaseEntity implements Serializable, Creatable, Modifiable {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private String mobile;
//
//    @Column(name="password")
//    @ColumnTransformer(
//            read= "AES_DECRYPT(password, '"+ DatabaseConstant.ENCRYPTION_KEY +"')",
//            write = "AES_ENCRYPT(?, '"+ DatabaseConstant.ENCRYPTION_KEY +"')")
//    private String password;
//
//    private Integer roleId;
//
//}
