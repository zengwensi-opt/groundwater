package com.groundwater.support.modules.system.dao;

import com.groundwater.support.modules.system.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
}