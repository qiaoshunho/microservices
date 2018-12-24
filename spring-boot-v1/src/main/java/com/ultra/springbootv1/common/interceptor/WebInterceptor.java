package com.ultra.springbootv1.common.interceptor;

import com.ultra.springbootv1.common.json.JSONResult;
import com.ultra.springbootv1.model.UserInfo;
import com.ultra.springbootv1.util.JsonUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @desc: 拦截器具体实现
 * @Author: ZhaoJP
 * @Date: 2018/12/21
 */
@Component
public class WebInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("---------------当拦截来临时,莫慌!!!!--------------------");
        HttpSession session = request.getSession();
        //这里的User是登陆时放入session的
        UserInfo user = (UserInfo) session.getAttribute("user");
        //如果session中没有user，表示没登陆
        if (user == null){
            //没登录直接重定向
            response.sendRedirect("/login/login");
            return false;
        }else {
            return true;
        }
        //returnErrorResponse(response, JSONResult.errorMsg("被two拦截..."));
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    public void returnErrorResponse(HttpServletResponse response, JSONResult result) throws IOException, UnsupportedEncodingException {
        OutputStream out=null;
        try{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
            out.flush();
        } finally{
            if(out!=null){
                out.close();
            }
        }
    }
}
