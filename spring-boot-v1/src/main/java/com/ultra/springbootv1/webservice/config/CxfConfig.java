package com.ultra.springbootv1.webservice.config;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/1/4
 */

import com.ultra.springbootv1.webservice.service.DemoService;
import com.ultra.springbootv1.webservice.service.impl.DemoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.xml.ws.Endpoint;

/**
 * cxf配置
 *
 * 访问地址 两种方式:
 *    http://{ip}:{端口}/{项目名}/services?wsdl
 *    http://{ip}:{端口}/{项目名}/services/DemoService?wsdl
 *
 */
@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private DemoService demoService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, demoService);
        endpoint.publish("/DemoService");
        return endpoint;

    }
}
