package com.groundwater.support.modules.system.dao;

import com.groundwater.support.modules.system.domain.UserConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserConfigMapper extends BaseMapper<UserConfig> {
}