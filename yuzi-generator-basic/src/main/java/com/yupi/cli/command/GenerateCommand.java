package com.yupi.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.generator.MainGenerator;
import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
    /**
     * 是否生成循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, description = "是否循环",arity = "0..1", interactive = true,echo = true)
    private boolean loop = true;

    /**
     * 作者注释
     */
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者",arity = "0..1", interactive = true,echo = true)
    private String author="yupi";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o", "--outputText"}, description = "输入文本",arity = "0..1", interactive = true,echo = true)
    private String outputText="sum = ";

    @Override
    public  Integer call() throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
