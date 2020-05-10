package com.groundwater.support.modules.common;



import java.util.HashMap;
import java.util.Map;

/**
 * @description  常量类
 * @author wensi
 */
public class Constant {

    public final static Map<String,String> WELL_INFO_HEAD = new HashMap<String,String>(){{
        put("表号","tableId");
        put("监测井留存情况","monitorWellKeep");
        put("监测井统一编号","monitorWellId");
        put("原始编号","originMonitorWellId");
        put("监测井地理坐标经度","longitude");
        put("监测井地理纬度","latitude");
        put("所在地及区划所在地","belongAddr");
        put("所在地及区划区域代码（12位）","belongAreaCode");
        put("监测井归属单位(企业)","belongCompany");
        put("联系人姓名","connectPersonName");
        put("联系方式","connectPersonTel");
        put("行业名称1","industryName1");
        put("行业代码1","industryCode1");
        put("行业名称2","industryName2");
        put("行业代码2","industryCode2");
        put("地下水系统分区","subarea");
        put("建井时间","wellCreateTime");
        put("井深(m)","wellDeep");
        put("含水介质类型","mediumTypeName");
        put("井管外径(mm)","pipeOutDiameter");
        put("井管类型","pipeTypeName");
        put("水位埋深(m)","levelDepth");
        put("监测层位","monitorHorizonName");
        put("监测因子选项","monitorFactorName");
        put("监测因子备注","monitorFactorRemark");
        put("监测频率","monitorRate");
        put("与场地方位关系选项","positionRelationName");
        put("与场地方位关系备注","positionRelationRemark");
        put("与地下水流方位关系","flowPositionRelationName");
        put("监测井型式","wellTypeName");
        put("地下水监测井性质","wellPropertyName");
        put("监测井类别","wellCategoryName");
        put("井管长度地表下xx米","pipeLengthBegin");
        put("井管长度至xx米","pipeLengthEnd");
        put("滤水管长度地表下xx米","filterPipeLengthBegin");
        put("滤水管长度至xx米","filterPipeLengthEnd");
        put("沉淀管长度地表下xx米","setPipeLengthBegin");
        put("沉淀管长度至xx米","setPipeLengthEnd");
        put("监测井周边污染源分布选项","surroundPollutionName");
        put("监测井周边污染源分布备注","surroundPollutionRemark");
        put("备注","remark");
        put("填表人","fillOutName");
        put("填表人联系电话","fillOutTel");
        put("审核人","checkName");
        put("填报日期","fillOutDate");




    }};
}
