//package com.mj.admin.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.mj.dao.mapper.other",sqlSessionFactoryRef = "otherSqlSessionFactory")
//public class MybatisDbOtherConfig {
//    @Bean(name = "other")
//    @ConfigurationProperties(prefix = "spring.datasource.other")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Bean(name = "otherTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("other") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "otherSqlSessionFactory")
//    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("other") DataSource basicDataSource) throws Exception{
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(basicDataSource);
//        factoryBean.setTypeAliasesPackage("com.mj.dao.entity");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/mj/dao/mapper/*Mapper.xml"));
//        return factoryBean.getObject();
//    }
//    @Bean(name = "otherSqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("otherSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
