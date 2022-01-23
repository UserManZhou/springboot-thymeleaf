package com.springboot.web.servletRegister;

import com.springboot.web.servlet.MyFilter;
import com.springboot.web.servlet.MyListener;
import com.springboot.web.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyServletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return  new ServletRegistrationBean(new MyServlet(), "/my");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        return new FilterRegistrationBean(new MyFilter(), new ServletRegistrationBean(new MyServlet(), "/my"));
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean(new MyListener());
    }

}
