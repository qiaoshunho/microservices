# microservices
Spring Boot 和 Spring Cloud系列

基于对spring-boot-v1的说明:

  (1)2018-12-21 初始提交 junit 测试类中实现了 基于spring-data-jpa各种情况的查询,包括动态sql,分页,单表,多表关联
  
  (2)本工程实现了多数据源, primary为oracle second为mysql(数据源最好统一都为oracle或者mysql)
  
  (3)实现了全局异常的处理以及统一格式的封装Json
  
  (4)2018-12-24 新增拦截器并实现登录校验功能
  
  (5)2018-12-29 封装分页工具类,具体实现参考UserController-->getUsers方法

  (6)2019-01-03 增加thymeleaf分页封装
  
  (7)2019-01-03 增加基于CXF实现的webservice功能
  
  (8)2019-01-17 增加log-back日志统一管理
