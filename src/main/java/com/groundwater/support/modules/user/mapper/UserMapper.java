package com.groundwater.support.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.Pagination;
import com.groundwater.support.modules.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wensi
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 分页查询用户
     * @param myPage 分页信息
     * @return 分页信息
     */
    IPage<User> selectUserPage(@Param("pg") Pagination<User> myPage);

    /**
     * 获取用户列表
     * @param user 用户信息
     * @return 用户列表
     */
    List<User> findList(@Param("user") User user );


}