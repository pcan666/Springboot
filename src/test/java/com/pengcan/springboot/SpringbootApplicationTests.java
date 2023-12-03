package com.pengcan.springboot;

import com.pengcan.springboot.entity.User;
import com.pengcan.springboot.mapper.UserMapper;
import com.pengcan.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
   @Test
    public void updateTest(){
//       User user = new User();
//       user.setId(6);
//       user.setUserName("zhangsan");
//       int i = userService.save(user);
//       System.out.println(i);
   }

}
