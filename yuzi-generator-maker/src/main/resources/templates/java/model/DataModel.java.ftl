package com.${basePackage}.maker.model;

import lombok.Data;

/**
 * 数据模型
 */
@Data
public class DataModel {
<#list modelConfig.models as modeInfo>

    <#if modeInfo.description??>
     /**
      * ${modeInfo.description}
      */
    </#if>
    private ${modeInfo.type} ${modeInfo.fieldName}<#if modeInfo.defaultValue??>=${modeInfo.defaultValue?c}</#if>;
</#list>

}
