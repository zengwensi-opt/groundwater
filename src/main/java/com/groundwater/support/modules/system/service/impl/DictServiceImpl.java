package com.groundwater.support.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.groundwater.support.modules.common.domain.QueryRequest;
import com.groundwater.support.modules.common.utils.SortUtil;
import com.groundwater.support.modules.system.dao.DictMapper;
import com.groundwater.support.modules.system.domain.Dict;
import com.groundwater.support.modules.system.service.DictService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service("dictService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    public IPage<Dict> findDicts(QueryRequest request, Dict dict) {
        try {
            LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();

            if (StringUtils.isNotBlank(dict.getKeyy())) {
                queryWrapper.eq(Dict::getKeyy, dict.getKeyy());
            }
            if (StringUtils.isNotBlank(dict.getValuee())) {
                queryWrapper.eq(Dict::getValuee, dict.getValuee());
            }
            if (StringUtils.isNotBlank(dict.getTableName())) {
                queryWrapper.eq(Dict::getTableName, dict.getTableName());
            }
            if (StringUtils.isNotBlank(dict.getFieldName())) {
                queryWrapper.eq(Dict::getFieldName, dict.getFieldName());
            }

            Page<Dict> page = new Page<>();
            SortUtil.handlePageSort(request, page, true);
            return this.page(page, queryWrapper);
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return null;
        }
    }

    @Override
    @Transactional
    public void createDict(Dict dict) {
        this.save(dict);
    }

    @Override
    @Transactional
    public void updateDict(Dict dict) {
        this.baseMapper.updateById(dict);
    }

    @Override
    @Transactional
    public void deleteDicts(String[] dictIds) {
        List<String> list = Arrays.asList(dictIds);
        this.baseMapper.deleteBatchIds(list);
    }

    @Override
    public List<Dict> getDict(String tableName,String fieldName){
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("TABLE_NAME",tableName).eq("FIELD_NAME",fieldName);
        return this.list(queryWrapper);
    }
    @Override
    public String getDict(String tableName, String fieldName,String value){
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("TABLE_NAME",tableName).eq("FIELD_NAME",fieldName).eq("VALUEE",value);
        Dict dict =  this.getOne(queryWrapper);
        if(null !=dict ){
            return dict.getKeyy();
        }
        return null ;

    }

}
