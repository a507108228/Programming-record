package com.lzw;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @author a5071
 * @since 2021/9/20 17:19
 * @description: 代码生成器
 */
public class CodeGenerator{

    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        // 注意这里的绝对路径是可以修改的
        gc.setOutputDir("D:\\Teaching\\Idea\\springboot\\demo_04" + "/src/main/java");

        gc.setAuthor("lzw");
        // 生成后是否打开资源管理器
        gc.setOpen(false);
        // 重新生成时文件是否覆盖
        gc.setFileOverride(false);

        // UserServie
        gc.setServiceName("%sService");	//去掉Service接口的首字母I
        // 主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        //定义生成的实体类中日期类型
        gc.setDateType(DateType.ONLY_DATE);
        // 开启Swagger2模式
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        // 注意这里 随时更改保持机动
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://lzw-5071.mysql.rds.aliyuncs.com:3306/revisecode?useSSL=false&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("lzw");
        dsc.setPassword("Pwds1308tgb");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        // 随时更改 保持机动
        PackageConfig pc = new PackageConfig();
        pc.setParent("com");

        //包  com.lzw.admin
        pc.setModuleName("lzw"); //模块名

        //包  com.lzw.admin.controller
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        // 因为是根据数据库表来进行生成代码的 所以此处要和数据库中的表保持一致
        strategy.setInclude("tbl_book");

        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成实体时去掉表前缀
        strategy.setTablePrefix(pc.getModuleName() + "_");

        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setEntityLombokModel(true);

        // restful api风格控制器
        strategy.setRestControllerStyle(true);
        // url中驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);


        // 6、执行
        mpg.execute();
    }
}

