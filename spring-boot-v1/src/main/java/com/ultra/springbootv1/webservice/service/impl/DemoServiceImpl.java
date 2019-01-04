package com.ultra.springbootv1.webservice.service.impl;

import com.ultra.springbootv1.webservice.service.DemoService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/1/4
 */
@WebService(
        serviceName = "DemoService",   // 暴露服务名称
        targetNamespace = "http://service.webservice.springbootv1.ultra.com/", // 命名空间,一般是接口的包名倒序
        endpointInterface = "com.ultra.springbootv1.webservice.service.DemoService"  // 接口地址
)
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String test(String xml) {
        return "webservice demo get param:" + xml;
    }

}
