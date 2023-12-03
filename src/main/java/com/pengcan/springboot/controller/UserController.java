package com.pengcan.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pengcan.springboot.entity.User;
import com.pengcan.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //    @Autowired
//    private UserMapper userMapper;
    @Autowired
    private UserService userService;

   /* //查询所有
    @GetMapping("selectAll")
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    //插入
    @PostMapping("insert")
    public Integer insert(@RequestBody User user) {
        return userMapper.insert(user);
    }

    //更新
    @PostMapping("update")
    public Integer update(@RequestBody User user) {
        return userMapper.update(user);
    }

    @PostMapping("save")
    public boolean save(@RequestBody User user) {
        return userService.saveUser(user);
    }


    //删除
    @DeleteMapping("del/{id}")
    public Integer delete(@PathVariable int id) {
        return userMapper.delete(id);
    }


    */

    /**
     * 分页查询
     *
     * @param pageNum  第几页
     * @param pageSize 一页展示多少条内容
     * @return
     *//*
    @GetMapping("page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username,
                                        @RequestParam String email,
                                        @RequestParam String address) {
        pageNum = (pageNum - 1) * pageSize;
        Integer total = userMapper.selectTotal(username,email,address);//条数
        List<User> data = userMapper.selectPage(pageNum, pageSize, username,email,address);//
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }*/
    //mybatis-plus实现
    //增&改
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    //删
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return userService.removeById(id);
    }
    //批量删除
    @PostMapping("/delete/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
    }

    //查
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.list();
    }

    //分页查询
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String email,
                                @RequestParam(defaultValue = "") String address) {
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!"".equals(username),"user_name", username);
        queryWrapper.like(!"".equals(email),"email", email);
        queryWrapper.like(!"".equals(address),"address", address);
        queryWrapper.orderByDesc("id");
        return userService.page(page, queryWrapper);
    }
}
