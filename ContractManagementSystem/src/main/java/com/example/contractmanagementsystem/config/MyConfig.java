package com.example.contractmanagementsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/addCustomer").setViewName("addCustomer");
        registry.addViewController("/authorize").setViewName("authorize");
        registry.addViewController("/addRole").setViewName("addRole");
        registry.addViewController("/addUser").setViewName("addUser");
        registry.addViewController("/draft").setViewName("draft");
        registry.addViewController("/sign").setViewName("sign");
        registry.addViewController("/finalize").setViewName("finalize");
        registry.addViewController("/approve").setViewName("approve");
        registry.addViewController("/finish").setViewName("finish");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/draft")
                .addPathPatterns("/approve")
                .addPathPatterns("/addCustomer");
    }
}
