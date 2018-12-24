package com.ultra.springbootv1.common.config;

import com.ultra.springbootv1.common.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @desc: 配置拦截器
 * @Author: ZhaoJP
 * @Date: 2018/12/21
 */
@Configuration
public class WebInterceptorConfigurer implements WebMvcConfigurer {

    private WebInterceptor webInterceptor;

    public WebInterceptorConfigurer(WebInterceptor webInterceptor) {
        this.webInterceptor = webInterceptor;
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // addPathPatterns("/**") 表示拦截所有的请求，
        registry.addInterceptor(webInterceptor).addPathPatterns("/**")
                //表示除登陆与注册不需要拦截
                .excludePathPatterns("/login/**", "/static/**", "/");
    }
}
