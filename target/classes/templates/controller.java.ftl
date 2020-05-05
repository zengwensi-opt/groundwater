package ${package.Controller};

import com.groundwater.support.modules.common.Result;
import com.groundwater.support.modules.common.ResultUtil;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.common.MsgUtil;
import com.groundwater.support.modules.common.Pagination;
import ${package.Entity}.${entity};


import javax.annotation.Resource;
<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
*
* ${table.comment!} 前端控制器
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>")
<#if kotlin>class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if><#else><#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{<#else>public class ${table.controllerName} {</#if>


    @Resource
    private ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};


    @PostMapping("<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/selectPage")
    public Result<IPage<${entity}>> selectPage(@RequestBody Pagination<${entity}> iPage){
        return ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS,${(table.serviceName?substring(1))?uncap_first}.selectPage(iPage));

    }

    @GetMapping("<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/getById/{id}")
    public Result<${entity}> getById(@PathVariable("id") String id){
        return  ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS, ${(table.serviceName?substring(1))?uncap_first}.getById(id));
    }

    @PostMapping("<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/add")
    public Result add(@RequestBody ${entity} ${entity?uncap_first}){

        boolean flag = ${(table.serviceName?substring(1))?uncap_first}.add(${entity?uncap_first});
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.ADD_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.ADD_FAIL,false);
        }
    }

    @DeleteMapping("<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/delete/{ids}")
    public Result delete(@PathVariable("ids") String ids){

        boolean flag = ${(table.serviceName?substring(1))?uncap_first}.delete(ids);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.DELETE_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.DELETE_FAIL,false);
        }
    }

    @PutMapping("<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>/update")
    public Result update(@RequestBody ${entity} ${entity?uncap_first}){
        boolean flag = ${(table.serviceName?substring(1))?uncap_first}.update(${entity?uncap_first});
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.ADD_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.ADD_FAIL,false);
        }
    }
}
</#if>