package com.example.resolvertest.config;

import com.example.resolvertest.config.interceptor.UserInterceptor;
import com.example.resolvertest.config.resolver.UserResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final UserInterceptor userInterceptor;
    private final UserResolver userResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(userResolver);
    }

}
