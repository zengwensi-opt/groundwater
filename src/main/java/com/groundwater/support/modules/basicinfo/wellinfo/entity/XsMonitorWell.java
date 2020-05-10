package com.groundwater.support.modules.basicinfo.wellinfo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 其他地下水环境监测井基本情况表
 * </p>
 *
 * @author wensi
 * @since 2020-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("xs_monitor_well")
public class XsMonitorWell implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 监测井统一编号(主键）
     */
    @TableId
    private String monitorWellId;

    /**
     * 监测井原始编码
     */
    private String originMonitorWellId;

    /**
     * 表号
     */
    private String tableId;

    /**
     * 监测井留存情况 0否 1是
     */
    private String monitorWellKeep;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 所在地
     */
    private String belongAddr;

    /**
     * 区划代码
     */
    private String belongAreaCode;

    /**
     * 归属单位（企业）
     */
    private String belongCompany;

    /**
     * 联系人姓名
     */
    private String connectPersonName;

    /**
     * 联系方式
     */
    private String connectPersonTel;

    /**
     * 行业名称1
     */
    private String industryName1;

    /**
     * 行业代码1
     */
    private String industryCode1;

    /**
     * 行业名称2
     */
    private String industryName2;

    /**
     * 行业代码2
     */
    private String industryCode2;

    /**
     * 地下水系统分区
     */
    private String subarea;

    /**
     * 建井时间
     */
    private LocalDate wellCreateTime;

    /**
     * 井深（m）
     */
    private BigDecimal wellDeep;

    /**
     * 介质类型id
     */
    private String mediumTypeId;

    /**
     * 介质类型名称
     */
    private String mediumTypeName;

    /**
     * 井管外径（mm）
     */
    private BigDecimal pipeOutDiameter;

    /**
     * 井管类型id
     */
    private String pipeTypeId;

    /**
     * 井管类型名称
     */
    private String pipeTypeName;

    /**
     * 水位埋深（m）
     */
    private BigDecimal levelDepth;

    /**
     * 监测层位id
     */
    private String monitorHorizonId;

    /**
     * 监测层位name
     */
    private String monitorHorizonName;

    /**
     * 监测因子id
     */
    private String monitorFactorId;

    /**
     * 监测因子name
     */
    private String monitorFactorName;

    /**
     * 监测因子备注
     */
    private String monitorFactorRemark;

    /**
     * 监测频率
     */
    private String monitorRate;

    /**
     * 与场地方位关系id
     */
    private String positionRelationId;

    /**
     * 与场地方位关系name
     */
    private String positionRelationName;
    /**
     * 与场地方位关系备注
     */
    private String positionRelationRemark ;

    /**
     * 与地下水流方位关系id
     */
    private String flowPositionRelationId;

    /**
     * 与地下水流方位关系name
     */
    private String flowPositionRelationName;

    /**
     * 监测井型式id
     */
    private String wellTypeId;

    /**
     * 监测井型式name
     */
    private String wellTypeName;

    /**
     * 地下水监测井性质id
     */
    private String wellPropertyId;

    /**
     * 地下水监测井性质name
     */
    private String wellPropertyName;

    /**
     * 监测井类别id
     */
    private String wellCategoryId;

    /**
     * 监测井类别name
     */
    private String wellCategoryName;

    /**
     * 井管长度从xxx米
     */
    private BigDecimal pipeLengthBegin;

    /**
     * 井管长度到xxx米
     */
    private BigDecimal pipeLengthEnd;

    /**
     * 滤水管长度从xxx米
     */
    private BigDecimal filterPipeLengthBegin;

    /**
     * 滤水管长度到xxx米
     */
    private BigDecimal filterPipeLengthEnd;

    /**
     * 沉淀管长度从xxx米
     */
    private BigDecimal setPipeLengthBegin;

    /**
     * 沉淀管长度到xxx米
     */
    private BigDecimal setPipeLengthEnd;

    /**
     * 监测井周边污染源分布id
     */
    private String surroundPollutionId;

    /**
     * 监测井周边污染源分布name
     */
    private String surroundPollutionName;

    /**
     * 监测井周边污染源分布备注
     */
    private String surroundPollutionRemark;

    /**
     * 备注
     */
    private String remark;

    /**
     * 填表人
     */
    private String fillOutName;

    /**
     * 填表人联系方式
     */
    private String fillOutTel;

    /**
     * 审核人
     */
    private String checkName;

    /**
     * 填表日期
     */
    private LocalDate fillOutDate;

    /**
     * 删除标志
     */
    @TableLogic
    private String delFlag;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建人name
     */
    private String createUserName;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime gmtModify;


}
