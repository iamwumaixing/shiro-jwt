package com.wu.jwt_shiro.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.Scanner;

/**
 * mybatis-plus 代码生成器
 *
 * @author Qwu
 */
public class GeneratorUtil {
    public static void main(String[] args) throws Exception {
        System.out.println("==========开启Mybatis-plus逆向工程==========");
        Scanner sc = new Scanner(System.in);
        System.out.println("==========请输入表名：");
        String tableName = sc.nextLine();
        System.out.println("==========请输入生成名：");
        String generatorName = sc.nextLine();
        System.out.println("==========\n表名："+tableName+"\n生成名："+generatorName+"\n==========");
        System.out.println("确认继续?(Y/N)");
        String flag = sc.nextLine();
        if ("Y".equals(flag)) {
            generatorCode(tableName,generatorName);
        } else {
            System.out.println("==========End==========");
        }


    }

    private static void generatorCode (String tableName,String generatorName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("Qwu");
        gc.setOpen(false);
        String na = "123";
        gc.setEntityName(generatorName);
        gc.setControllerName(generatorName+"Controller");
        gc.setServiceName(generatorName+"Service");
        gc.setServiceImplName(generatorName+"ServiceImpl");
        gc.setMapperName(generatorName+"Mapper");
        gc.setXmlName(generatorName+"Mapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/jwtdemo?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("1997");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.wu.jwt_shiro");
        mpg.setPackageInfo(pc);

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为表前缀
        strategy.setNaming(NamingStrategy.no_change);
        strategy.setInclude(tableName);
        mpg.setStrategy(strategy);

        // 执行生成
        mpg.execute();
    }
}
