package com.storelocator.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author  
 * 		   This class is the entry point of application. It
 *         configures the required Datasource ,SessionFactory beans and Embedded
 *         Tomcat
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.storelocator" })
public class ApplicationInitializer extends SpringBootServletInitializer {
	
	//Data source object to be used for constructing session factory
	@Autowired
	private DataSource dataSource;

	//Packages to be scanned for JPA Entity beans
	private static final String ENTITY_PACKAGES_TO_SCAN = "com.storelocator.entity";

	
	/*
	 * @return Hibernate Session Factory Bean
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
		return sessionFactoryBean;
	};
	
	/*
	 * @return EmbeddedServletContainerFactory
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(8086);
		return factory;
	}

	/*
	 * @return SpringApplicationBuilder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationInitializer.class);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInitializer.class, args);
	}
}
