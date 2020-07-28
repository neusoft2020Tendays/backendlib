package com.hitstu.oa.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//Spring 配置类，用于配置Spring集成MyBatis

@Configuration
@ComponentScan(basePackages= {"com.hitstu.oa"})
@EnableAspectJAutoProxy
@MapperScan(basePackages={"com.hitstu.oa.hr.mapper","com.hitstu.oa.checkin.mapper"})
@EnableTransactionManagement  //启用事务Advice
public class SpringConfigForSM {
	//配置HirariCP连接池
	@Bean
	public DataSource createHikariCPDataSource() throws Exception{
			HikariConfig config = new HikariConfig("/hikari.properties");
			HikariDataSource ds = new HikariDataSource(config);			
			return ds;
	}
	//配置Mybatis SqlSessionFactory的工厂Bean
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
	  SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
	  factoryBean.setDataSource(dataSource);
	  //配置读取XML映射文件
	  ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	  factoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:mapping/**/*.xml"));
	  //读取MyBatis配置文件
	  Resource resource= new ClassPathResource("mybatisconfigforSM.xml");
	  factoryBean.setConfigLocation(resource);	
	  //设置Model类别名的扫描路径
	  factoryBean.setTypeAliasesPackage("com.hitstu.oa.hr.model, com.hitstu.oa.checkin.model");	
	  return factoryBean.getObject();
	}
	//配置事务管理器
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		  return new DataSourceTransactionManager(dataSource);
	}
	
	
	

}
