package com.pengcan.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pengcan.springboot.entity.User;
import com.pengcan.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {
//    public boolean saveUser(User user) {
//        if (user.getId()==null) {
//            return save(user);
//        }else {
//            return updateById(user);
//        }
//        return saveOrUpdate(user);
//    }

//    @Autowired
//    private UserMapper userMapper;

//    public int save(User user){
//        if (user.getId()==null||user.getId()==0) {
//            return userMapper.insert(user);
//        }else {
//           return userMapper.update(user);
//        }
//    }
}
