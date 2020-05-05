package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.Pagination;
import java.util.Arrays;

/**
*
* ${table.comment!} 服务实现类
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public IPage<${entity}> selectPage(Pagination<${entity}> iPage){
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        ${entity} param = iPage.getParam();
        if(null!=param){
           //do something
        }
        return this.page(iPage,wrapper);
    }

    @Override
    public boolean add(${entity} ${entity?uncap_first}){
        return this.saveOrUpdate(${entity?uncap_first});
    }

    @Override
    public boolean delete(String ids){
        return this.removeByIds(Arrays.asList(ids.split(",")));
    }

    @Override
    public boolean update(${entity} ${entity?uncap_first}){
        return this.updateById(${entity?uncap_first});
    }
}
</#if>