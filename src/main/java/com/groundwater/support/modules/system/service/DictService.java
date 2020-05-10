package com.groundwater.support.modules.system.service;

import com.groundwater.support.modules.common.domain.QueryRequest;
import com.groundwater.support.modules.system.domain.Dict;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface DictService extends IService<Dict> {

    IPage<Dict> findDicts(QueryRequest request, Dict dict);

    void createDict(Dict dict);

    void updateDict(Dict dicdt);

    void deleteDicts(String[] dictIds);

    /**
     * 获取数据字典
     * @param tableName 表格名称
     * @param fieldName 字段名称
     * @return
     */
    List<Dict> getDict(String tableName, String fieldName);
    /**
     * 获取数据字典
     * @param tableName 表格名称
     * @param fieldName 字段名称
     * @param value 字段值
     * @return
     */
    String getDict(String tableName, String fieldName,String value);

}
