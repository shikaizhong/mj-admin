package com.mj.admin;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

//@Import({DynamicDataSourceRegister.class})
@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"com.mj"},exclude = DataSourceAutoConfiguration.class)
@MapperScan(value = "com.mj.dao.repository")
//public class AdminApplication extends SpringBootServletInitializer {
public class AdminApplication{

//    @Bean
//    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
//        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
//    }
        @Bean
        public PageHelper pageHelper() {
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("offsetAsPageNum", "true");
            properties.setProperty("rowBoundsWithCount", "true");
            properties.setProperty("reasonable", "true");
            properties.setProperty("dialect", "mysql");
            pageHelper.setProperties(properties);
            return pageHelper;
        }
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(AdminApplication.class);
//    }
}

