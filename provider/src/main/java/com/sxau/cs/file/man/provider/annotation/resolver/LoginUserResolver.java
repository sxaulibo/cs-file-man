package com.sxau.cs.file.man.provider.annotation.resolver;

import com.sxau.cs.file.man.biz.UserBiz;
import com.sxau.cs.file.man.common.model.beans.LoginUserInfo;
import com.sxau.cs.file.man.provider.annotation.LoginUser;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

@Component
public class LoginUserResolver implements HandlerMethodArgumentResolver {
    @Resource
    private UserBiz userBiz;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(LoginUserInfo.class) && methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //自定义业务逻辑
        return userBiz.getLoginUserInfo();
    }
}
