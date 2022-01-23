package com.springboot.web.config;

import com.springboot.web.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ServletComponentScan(basePackages = "com.springboot.web")
public class SpringConfig {

    private WebInterceptor webInterceptor;

    @Autowired
    private void webInterceptor(WebInterceptor webInterceptor){
        this.webInterceptor = webInterceptor;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(webInterceptor)
                        .addPathPatterns("/**")
                        .excludePathPatterns("/","/login","/dologin","/css/**","/js/**","/images/**","/fonts/**");
            }
        };
    }
}
