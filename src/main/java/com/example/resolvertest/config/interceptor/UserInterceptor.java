package com.example.resolvertest.config.interceptor;

import com.example.resolvertest.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        String userId = request.getHeader("user-info");

        UserDTO user = new UserDTO();
        user.setUserId(userId);
        user.setUsername(userId+" user");

        request.setAttribute("user", user);

        log.info("==== HttpServletRequest setAttribute user ====");
        return true;
    }
}
