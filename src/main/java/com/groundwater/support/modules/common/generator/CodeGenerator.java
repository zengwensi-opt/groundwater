package com.groundwater.support.modules.common.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author wensi
 */
@RestController
public class CodeGenerator {
    public final static String MODULENAME_PARENT = "com.groundwater.support.modules";

    @GetMapping("/code/generator/{moduleName}/{tableName}/{author}")
    public static void generator(@PathVariable String moduleName,@PathVariable String  tableName,@PathVariable String author) throws Exception{
        String projectPath = System.getProperty("user.dir");
        //配置文件
        Properties properties = new Properties();
        InputStream inStream = new FileInputStream(new File(projectPath+"/src/main/resources/config/application-dev.yml"));
        properties.load(inStream);

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig(projectPath,author));
        // 数据源配置
        mpg.setDataSource(getDataSourceConfig(properties));

        // 包配置
        PackageConfig pc = getPackageConfig(moduleName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


//        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);


        mpg.setStrategy(getStrategyConfig(tableName,pc));
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    private static PackageConfig getPackageConfig(String moduleName){
        PackageConfig pc = new PackageConfig();

        pc.setModuleName(moduleName);
        pc.setParent(MODULENAME_PARENT);
        return pc;
    }

    private static DataSourceConfig getDataSourceConfig(Properties properties){
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(properties.getProperty("url"));
        // dsc.setSchemaName("public");
        dsc.setDriverName(properties.getProperty("driver-class-name"));
        dsc.setUsername(properties.getProperty("username"));
        dsc.setPassword(properties.getProperty("password"));
        return dsc ;
    }

    private static GlobalConfig getGlobalConfig(String projectPath,String author){
        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setBaseResultMap(true);
        gc.setAuthor(author);
        gc.setOpen(false);
        return gc;
    }

    private static StrategyConfig getStrategyConfig(String tableName,PackageConfig pc){
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);

        strategy.setLogicDeleteFieldName("del_flag");
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(new TableFill("gmt_create",FieldFill.INSERT));
        tableFills.add(new TableFill("gmt_modify",FieldFill.UPDATE));
        strategy.setTableFillList(tableFills);
        strategy.setInclude(tableName);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        return strategy;
    }
}
