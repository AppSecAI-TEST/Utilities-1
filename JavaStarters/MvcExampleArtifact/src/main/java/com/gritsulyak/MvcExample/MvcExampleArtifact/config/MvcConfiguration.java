package com.gritsulyak.MvcExample.MvcExampleArtifact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="com.gritsulyak.MvcExample.MvcExampleArtifact")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		System.out.println(resolver);
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		try {
			throw new Exception();
		}catch(Exception e) {
			System.out.println(e);
		}
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
}
