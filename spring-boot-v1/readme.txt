@modifying：
（1）可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作。
注意： JPQL 不支持使用 INSERT；
（2）在 @Query 注解中编写 JPQL 语句， 但必须使用 @Modifying 进行修饰. 以通知SpringData， 这是一个 UPDATE 或 DELETE 操作
（3）UPDATE 或 DELETE 操作需要使用事务，此时需要定义 Service 层，在 Service 层的方法上添加事务操作；
（4）默认情况下， SpringData 的每个方法上有事务， 但都是一个只读事务。

@Transactional：
A. 一个功能是否要事务，必须纳入设计、编码考虑。不能仅仅完成了基本功能就ok。
B. 如果加了事务，必须做好开发环境测试（测试环境也尽量触发异常、测试回滚），确保事务生效。
C. 以下列了事务使用过程的注意事项，请大家留意。
1. 不要在接口上声明@Transactional ，而要在具体类的方法上使用 @Transactional 注解，否则注解可能无效。
2.不要图省事，将@Transactional放置在类级的声明中，放在类声明，会使得所有方法都有事务。故@Transactional应该放在方法级别，不需要使用事务的方法，就不要放置事务，比如查询方法。否则对性能是有影响的。
3.使用了@Transactional的方法，对同一个类里面的方法调用， @Transactional无效。比如有一个类Test，它的一个方法A，A再调用Test本类的方法B（不管B是否public还是private），但A没有声明注解事务，而B有。则外部调用A之后，B的事务是不会起作用的。（经常在这里出错）
4.使用了@Transactional的方法，只能是public，@Transactional注解的方法都是被外部其他类调用才有效，故只能是public。道理和上面的有关联。故在 protected、private 或者 package-visible 的方法上使用 @Transactional 注解，它也不会报错，但事务无效。
5.经过在ICORE-CLAIM中测试，效果如下：
A.抛出受查异常XXXException，事务会回滚。
B.抛出运行时异常NullPointerException，事务会回滚。
C.Quartz中，execute直接调用加了@Transactional方法，可以回滚；间接调用，不会回滚。（即上文3点提到的）
D.异步任务中，execute直接调用加了@Transactional方法，可以回滚；间接调用，不会回滚。（即上文3点提到的）
E.在action中加上@Transactional，不会回滚。切记不要在action中加上事务。
F.在service中加上@Transactional，如果是action直接调该方法，会回滚，如果是间接调，不会回滚。（即上文3提到的）
G.在service中的private加上@Transactional，事务不会回滚。