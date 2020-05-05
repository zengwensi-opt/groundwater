package com.groundwater.support.modules.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.Pagination;
import com.groundwater.support.modules.user.entity.User;

import java.util.List;

/**
 * @author wensi
 */
public interface IUserService {


    /**
     * 获取单个用户信息
     * @param id 主键
     * @return 用户信息
     */
    User selectUser(String id);

    /**
     * 分页获取用户信息-xml版
     * @param iPage 分页信息
     * @return 用户分页
     */
    IPage<User> selectUserPage(Pagination<User> iPage);
    /**
     * 分页获取用户信息-wrapper版
     * @param iPage 分页信息
     * @return 用户分页
     */
    IPage<User> queryUserPage(Pagination<User> iPage);

    /**
     * 获取用户列表
     * @param user 查询条件
     * @return 用户列表
     */
    List<User> selectUserList(User user);

    /**
     * 删除用户信息
     * @param ids 主键id
     * @return 是否删除成功
     */
    boolean deleteUser(String ids);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 是否更新成功
     */
    boolean updateUser(User user);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 是否新增成功
     */
    boolean addUser(User user);





}
