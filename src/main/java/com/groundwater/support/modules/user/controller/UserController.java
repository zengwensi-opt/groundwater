package com.groundwater.support.modules.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.MsgUtil;
import com.groundwater.support.modules.common.Pagination;
import com.groundwater.support.modules.common.Result;
import com.groundwater.support.modules.common.ResultUtil;
import com.groundwater.support.modules.user.entity.User;
import com.groundwater.support.modules.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wensi
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService ;


    @GetMapping("/user/queryById/{id}")
    public Result<User> selectById(@PathVariable("id") String id){
        return  ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS,userService.selectUser(id));
    }

    @PostMapping("/user/updateUser")
    public Result<Object> selectById(@RequestBody User user){
        boolean flag = userService.updateUser(user);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.UPDATE_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.UPDATE_FAIL,false);
        }

    }

    @PostMapping("/user/pageUser")
    public Result<IPage<User>> selectPage(@RequestBody Pagination<User> iPage){
        return  ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS,userService.queryUserPage(iPage));
    }

    @PostMapping("/user/userList")
    public Result<List<User>> userList(@RequestBody User user){
        return  ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS,userService.selectUserList(user));
    }

    @DeleteMapping("/user/deleteUser/{ids}")
    public Result<Object> deleteUser(@PathVariable("ids") String ids){

        boolean flag = userService.deleteUser(ids);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.DELETE_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.DELETE_FAIL,false);
        }

    }

    @PostMapping("/user/addUser")
    public Result<Object> addUser(@RequestBody User user){

        boolean flag = userService.addUser(user);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.ADD_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.ADD_FAIL,false);
        }

    }
}
