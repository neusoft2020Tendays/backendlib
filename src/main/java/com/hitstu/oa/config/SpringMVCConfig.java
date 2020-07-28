package com.hitstu.oa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Spring MVC的IoC Bean配置类
//@Configuration
//@ComponentScan(basePackages = {"com.hitstu.oa"})
//@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {
	
	
	// 设置JSP结果解析器，对控制器返回的字符串，前面加：/	后面加：.jsp
	// 如果控制器返回：department/add，则最终结果是：/department/add.jsp
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		resolver.setRequestContextAttribute("requestContext");
		return resolver;
	}
}
