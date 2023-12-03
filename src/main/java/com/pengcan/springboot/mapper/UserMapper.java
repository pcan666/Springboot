package com.pengcan.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pengcan.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

//////    @Select("select * from user;")
//    List<User> selectAll();
//////    @Insert("insert into user (user_name, user_pwd, nick_name, email, phone, address) values (#{user_name},#{user_pwd},#{nick_name},#{email},#{phone},#{address})")
//    int insert(User user);
////
//    int update(User user);
////
//    int delete(Integer id);
//
//    List<User> selectPage(Integer pageNum, Integer pageSize,String username,String email,String address);
//    //数据总条数
////    Integer selectTotal();
//
//    Integer selectTotal(String username,String email,String address);
}
