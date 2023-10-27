package com.linzzxz.emos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

// 不使用autoconifg读取数据源配置，若不添加exclude则发生报错：
// Failed to determine a suitable driver class
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
// 使自定义Filter生效
@ServletComponentScan
public class EmosApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmosApplication.class, args);
    }

}
