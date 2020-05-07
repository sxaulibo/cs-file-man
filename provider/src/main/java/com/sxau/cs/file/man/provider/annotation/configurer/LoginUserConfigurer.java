package com.sxau.cs.file.man.provider.annotation.configurer;

import com.sxau.cs.file.man.provider.annotation.resolver.LoginUserResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class LoginUserConfigurer implements WebMvcConfigurer {
    @Resource
    private LoginUserResolver loginUserResolver;

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserResolver);
    }
}