package com.groundwater.support.modules.basicinfo.wellinfo.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.cell.CellEditor;
import com.groundwater.support.modules.common.*;
import org.apache.poi.ss.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.bind.annotation.*;
import com.groundwater.support.modules.basicinfo.wellinfo.service.IXsMonitorWellService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.groundwater.support.modules.basicinfo.wellinfo.entity.XsMonitorWell;


import javax.annotation.Resource;
    import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
*
* 其他地下水环境监测井基本情况表 前端控制器
*
* @author wensi
* @since 2020-05-10
*/
@RestController
@RequestMapping("/basicInfo/wellInfo")
public class XsMonitorWellController {


    @Resource
    private IXsMonitorWellService xsMonitorWellService;


    @PostMapping("selectPage")
    public Result<IPage<XsMonitorWell>> selectPage(@RequestBody Pagination<XsMonitorWell> iPage){
        return ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS,xsMonitorWellService.selectPage(iPage));

    }

    @GetMapping("getById/{id}")
    public Result<XsMonitorWell> getById(@PathVariable("id") String id){
        return  ResultUtil.getSuccess(MsgUtil.SELECT_SUCCESS, xsMonitorWellService.getById(id));
    }

    @PostMapping("add")
    public Result add(@RequestBody XsMonitorWell xsMonitorWell){

        boolean flag = xsMonitorWellService.add(xsMonitorWell);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.ADD_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.ADD_FAIL,false);
        }
    }

    @DeleteMapping("delete/{ids}")
    public Result delete(@PathVariable("ids") String ids){

        boolean flag = xsMonitorWellService.delete(ids);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.DELETE_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.DELETE_FAIL,false);
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody XsMonitorWell xsMonitorWell){
        boolean flag = xsMonitorWellService.update(xsMonitorWell);
        if(flag){
            return  ResultUtil.getSuccess(MsgUtil.ADD_SUCCESS,true);
        }else{
            return  ResultUtil.getError(MsgUtil.ADD_FAIL,false);
        }
    }

    @PutMapping("/import")
    public void importExcel(MultipartFile file) throws Exception{

        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        reader.setHeaderAlias(Constant.WELL_INFO_HEAD);

        List<XsMonitorWell> all = reader.read(0,1,XsMonitorWell.class);
        System.out.println();
    }
}
