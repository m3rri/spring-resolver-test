package com.example.resolvertest.config.resolver;

import com.example.resolvertest.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
@Slf4j
public class UserResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("==== parameter type check ====");
        return parameter.getParameterAnnotation(RequestUser.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer
                                , NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        log.info("==== set user argument ====");
        return webRequest.getAttribute("user", RequestAttributes.SCOPE_REQUEST);
    }
}
