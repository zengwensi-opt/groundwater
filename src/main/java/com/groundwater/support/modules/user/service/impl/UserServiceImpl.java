package com.groundwater.support.modules.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groundwater.support.modules.common.Pagination;
import com.groundwater.support.modules.user.entity.User;
import com.groundwater.support.modules.user.mapper.UserMapper;
import com.groundwater.support.modules.user.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author wensi
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User selectUser(String id) {
        return this.getById(id);
    }


    @Override
    public IPage<User> selectUserPage(Pagination<User> iPage) {

        return this.baseMapper.selectUserPage(iPage);
    }

    @Override
    public IPage<User> queryUserPage(Pagination<User> iPage) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User user = iPage.getParam();
        if(null!=user){
            Integer age = user.getAge();
            if(age !=null){
                wrapper.eq("age",age);
            }
            String name = user.getName();
            if(StringUtils.isNotBlank(name)){
                wrapper.eq("name",name);
            }

        }
        return this.page(iPage,wrapper);


    }

    @Override
    public List<User> selectUserList(User user) {

        return this.baseMapper.findList(user);

    }


    @Override
    public boolean deleteUser(String ids) {
        return this.removeByIds(Arrays.asList(ids.split(",")));

    }

    @Override
    public boolean updateUser(User user) {
        return this.updateById(user);
    }

    @Override
    public boolean addUser(User user){
        return this.saveOrUpdate(user);
    }

}
