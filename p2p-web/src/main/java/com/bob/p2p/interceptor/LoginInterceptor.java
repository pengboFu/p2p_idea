package com.bob.p2p.interceptor;

import com.bob.p2p.common.constant.Constants;
import com.bob.p2p.model.UserEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //从session中获取用户信息
        UserEntity userEntity = (UserEntity) httpServletRequest.getSession().getAttribute(Constants.USER_SESSION);
        if (null == userEntity) {
            //跳转至登录页面
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login.jsp");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
