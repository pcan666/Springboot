package com.pengcan.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User{
    @TableId(type = IdType.AUTO)
    private Integer id;//ID
    @TableField(value = "user_name")
    private String userName;//用户名
    @JsonIgnore//忽略密码字段不展示给前端
    private String userPwd;//用户密码
    private String nickName;//用户昵称
    private String email;//邮箱
    private String phone;//电话号码
    private String address;//地址
}
