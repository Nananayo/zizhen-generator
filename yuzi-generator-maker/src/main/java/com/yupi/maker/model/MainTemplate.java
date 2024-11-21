package com.yupi.maker.model;

import lombok.Data;

/**
 * 用于生成核心模板文件
 */
@Data
public class MainTemplate {
    /**
     * 作者注释
     */
    public String author = "yupi";

    /**
     * 输出信息
     */
    public String outputText = "sum = ";
}
