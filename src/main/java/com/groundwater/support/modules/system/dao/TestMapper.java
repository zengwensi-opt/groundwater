package com.groundwater.support.modules.system.dao;

import com.groundwater.support.modules.system.domain.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<Test> {
}