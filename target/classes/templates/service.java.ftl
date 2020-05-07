package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.Pagination;

/**
*
* ${table.comment!} 服务类
*
* @author ${author}
* @since ${date}
*/
<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
    * 查询分页数据
    *
    * @param iPage 分页信息
    * @return IPage
    */
    IPage<${entity}> selectPage(Pagination<${entity}> iPage);

    /**
    * 添加
    *
    * @param ${entity?uncap_first} 信息
    * @return boolean
    */
    boolean add(${entity} ${entity?uncap_first});

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
    * @param ${entity?uncap_first} 信息
    * @return boolean
    */
    boolean update(${entity} ${entity?uncap_first});

}
</#if>
