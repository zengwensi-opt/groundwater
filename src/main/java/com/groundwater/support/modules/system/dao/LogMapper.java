package com.groundwater.support.modules.system.dao;

import com.groundwater.support.modules.system.domain.SysLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<SysLog> {
}