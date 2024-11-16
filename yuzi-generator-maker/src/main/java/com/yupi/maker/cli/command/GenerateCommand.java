package com.yupi.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.yupi.maker.generator.file.FileGenerator;
import com.yupi.maker.model.DataModel;
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
    public Integer call() throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        FileGenerator.doGenerate(dataModel);
        return 0;
    }
}
