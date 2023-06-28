package cn.ztejjx.memberstore.config;

import cn.ztejjx.memberstore.intercepter.noTokenValidateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class IntercepterConfiguration implements WebMvcConfigurer {

    @Resource
    private noTokenValidateInterceptor noTokenValidate;

    /*注册拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(noTokenValidate).addPathPatterns("/api/v1/pri/**");
        registry.addInterceptor(noTokenValidate).excludePathPatterns("/api/v1/pub/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
