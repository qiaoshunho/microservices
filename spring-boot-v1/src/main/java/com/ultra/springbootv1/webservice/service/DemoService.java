package com.ultra.springbootv1.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/1/4
 */
@WebService
public interface DemoService {

    @WebMethod
    public String test(@WebParam(name = "xml") String xml);

}
