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
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.mj.dao.mapper.master",sqlSessionFactoryRef = "masterSqlSessionFactory")
//public class MybatisDbMasterConfig {
//    @Primary
//    @Bean(name = "master")
//    @ConfigurationProperties(prefix = "spring.datasource.master")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//    @Primary
//    @Bean(name = "masterSqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("master") DataSource dataSource)throws Exception{
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setTypeAliasesPackage("com.mj.dao.entity");
//        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/mj/dao/mapper/*Mapper.xml"));
//        return factoryBean.getObject();
//    }
//    //配置事务管理
//    @Primary
//    @Bean(name = "masterTransactionManager")
//    public DataSourceTransactionManager transactionManager(@Qualifier("master") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "masterSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(
//            @Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
