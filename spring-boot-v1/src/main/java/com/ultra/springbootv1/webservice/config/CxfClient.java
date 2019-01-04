package com.ultra.springbootv1.webservice.config;

import com.ultra.springbootv1.webservice.service.DemoService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2019/1/4
 */
public class CxfClient {

    /**
     *  方式1.代理类工厂的方式,缺点:需要拿到对方的接口 一般不会这么调用
     * @param args
     */
    public static void main1(String[] args) {
        try {
            // 接口地址
            String address = "http://localhost:8080/services/DemoService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(DemoService.class);
            // 创建一个代理接口实现
            DemoService cs = (DemoService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String xml = "Leftso";
            // 调用代理接口的方法调用并返回结果
            String result = cs.test(xml);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式2: 动态调用方式
     * @param args
     */
    public static void main(String[] args) {

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/DemoService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("test", "Leftso");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

}
