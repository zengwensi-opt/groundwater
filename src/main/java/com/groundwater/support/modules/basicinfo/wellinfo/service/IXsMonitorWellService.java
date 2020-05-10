package com.groundwater.support.modules.basicinfo.wellinfo.service;

import com.groundwater.support.modules.basicinfo.wellinfo.entity.XsMonitorWell;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.Pagination;

import java.util.List;

/**
*
* 其他地下水环境监测井基本情况表 服务类
*
* @author wensi
* @since 2020-05-10
*/
public interface IXsMonitorWellService extends IService<XsMonitorWell> {

    /**
    * 查询分页数据
    *
    * @param iPage 分页信息
    * @return IPage
    */
    IPage<XsMonitorWell> selectPage(Pagination<XsMonitorWell> iPage);

    /**
    * 添加
    *
    * @param xsMonitorWell 信息
    * @return boolean
    */
    boolean add(XsMonitorWell xsMonitorWell);

    /**
    * 删除
    *
    * @param ids 主键，多个主键用,隔开
    * @return boolean
    */
    boolean delete(String ids);

    /**
    * 修改信息
    *
    * @param xsMonitorWell 信息
    * @return boolean
    */
    boolean update(XsMonitorWell xsMonitorWell);

    /**
     * 导入数据
     * @param data 数据
     * @return
     */
    boolean importData(List<XsMonitorWell> data);

}
