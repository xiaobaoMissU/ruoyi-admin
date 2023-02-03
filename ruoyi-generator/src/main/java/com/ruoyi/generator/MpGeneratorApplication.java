package com.ruoyi.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MpGeneratorApplication {


    private static final String URL = "jdbc:mysql://localhost:3306/jimu";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "168690";
    private static final String OUTPUTDIR = System.getProperty("user.dir") + "/ruoyi-system/src/main/java";
    private static final String XMLOUTPUTDIR = System.getProperty("user.dir") + "/ruoyi-system/src/main/resources/mapper";
    private static final String PARENTPACKAGE = "com.ruoyi";
    private static final String MODULENAME = "system";
    private static final String[] dbTables = new String[]{
        "jimu_dict"
    };

    public static void main(String[] args) {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir()
                            .outputDir(OUTPUTDIR); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(PARENTPACKAGE) // 设置父包名
                            .moduleName(MODULENAME) // 设置父包模块名
                            .entity("domain")
                            .serviceImpl("dao")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XMLOUTPUTDIR)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(dbTables) // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_")
                            .entityBuilder().enableLombok().enableFileOverride()
                            .serviceBuilder().formatServiceImplFileName("%sDao")
                    ; // 设置过滤表前缀
                })
                .templateConfig(builder -> {
                    builder
                            .disable(TemplateType.CONTROLLER)
                            .disable(TemplateType.SERVICE)
                            .serviceImpl("/template/serviceImpl.java")

                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
