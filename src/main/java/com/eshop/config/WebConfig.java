package com.eshop.config;

import javax.naming.NamingException;
import javax.servlet.annotation.MultipartConfig;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@MultipartConfig
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.eshop" })
public class WebConfig extends WebMvcConfigurerAdapter {
 
// @Autowired
// DataSource dataSource;
// 
// @Bean
// public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
//  return new NamedParameterJdbcTemplate(dataSource);
// }
 
 /*@Bean
 public DataSource getDataSource() throws NamingException{
  JndiTemplate jndiTemplate = new JndiTemplate();
  DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/springmvc");
  return dataSource;
	//JndiDataSourceLookup lookup = new JndiDataSourceLookup();
	//return lookup.getDataSource("java:jboss/users");
 }
 */
}