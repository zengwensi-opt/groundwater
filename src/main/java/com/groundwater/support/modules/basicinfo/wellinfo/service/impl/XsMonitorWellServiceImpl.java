package com.groundwater.support.modules.basicinfo.wellinfo.service.impl;

import com.groundwater.support.modules.basicinfo.wellinfo.entity.XsMonitorWell;
import com.groundwater.support.modules.basicinfo.wellinfo.mapper.XsMonitorWellMapper;
import com.groundwater.support.modules.basicinfo.wellinfo.service.IXsMonitorWellService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.groundwater.support.modules.system.service.DictReflexService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.Pagination;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
*
* 其他地下水环境监测井基本情况表 服务实现类
*
* @author wensi
* @since 2020-05-10
*/
@Service
public class XsMonitorWellServiceImpl extends ServiceImpl<XsMonitorWellMapper, XsMonitorWell> implements IXsMonitorWellService {
    @Resource
    private DictReflexService dictReflex ;

    @Override
    public boolean importData(List<XsMonitorWell> data) {
        data.forEach(xsMonitorWell -> {
            //获得数据字典id
            dictReflex.dictReflex(xsMonitorWell,"positionRelationId",xsMonitorWell.getPositionRelationName(),"xs_monitor_well","positionRelationName");
        });
        return this.saveBatch(data);
    }

    @Override
    public IPage<XsMonitorWell> selectPage(Pagination<XsMonitorWell> iPage){
        QueryWrapper<XsMonitorWell> wrapper = new QueryWrapper<>();
        XsMonitorWell param = iPage.getParam();
        if(null!=param){
           //do something
        }
        return this.page(iPage,wrapper);
    }

    @Override
    public boolean add(XsMonitorWell xsMonitorWell){
        return this.saveOrUpdate(xsMonitorWell);
    }

    @Override
    public boolean delete(String ids){
        return this.removeByIds(Arrays.asList(ids.split(",")));
    }

    @Override
    public boolean update(XsMonitorWell xsMonitorWell){
        return this.updateById(xsMonitorWell);
    }
}
