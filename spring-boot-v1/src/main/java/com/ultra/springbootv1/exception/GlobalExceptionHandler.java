package com.ultra.springbootv1.exception;

import com.ultra.springbootv1.common.json.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc: 全局异常处理类 (web方式和ajax请求方式) 目的: 以更友好的方式返回前端
 * @Author: ZhaoJP
 * @Date: 2018/12/21
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR_HTML = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        e.printStackTrace();

        if (isAjax(request)) {//ajax请求方式的异常

            return JSONResult.errorException(e.getMessage());
        } else {//web请求方式的异常

            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_HTML);
            return mav;
        }
    }

    public static boolean isAjax(HttpServletRequest httpRequest) {
        return httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString());
    }

}
