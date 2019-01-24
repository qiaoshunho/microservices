package com.ultra.springbootv1.controller;

import com.ultra.springbootv1.common.json.JSONResult;
import com.ultra.springbootv1.model.master.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/21
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/error")
    public String error() {

        int a = 1 / 0;

        return "thymeleaf/error";
    }

    @RequestMapping("/error1")
    public Object error1() {

        return new Exception();
    }

    @RequestMapping("/getAjax")
    @ResponseBody
    public JSONResult getAjax() {

        return JSONResult.ok();
    }

    @RequestMapping("/getAjaxObject")
    @ResponseBody
    public JSONResult getAjaxObject() {
        UserInfo userInfo = new UserInfo("zhaojp", "000000");
        userInfo.setId(1l);
        return JSONResult.ok(userInfo);
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public JSONResult getAjaxerror() {

        int a = 1 / 0;

        return JSONResult.ok();
    }


}
