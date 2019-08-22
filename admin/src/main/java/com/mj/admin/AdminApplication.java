package com.mj.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
//        return builder.sources(AdminApplication.class);
//    }
}

