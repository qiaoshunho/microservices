package com.ultra.springbootv1.quartz.task;

import com.ultra.springbootv1.model.master.UserInfo;
import com.ultra.springbootv1.service.UserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc: 定时任务执行
 * @Author: ZhaoJP
 * @Date: 2018/12/27
 */
@Service
public class UserTask extends QuartzJobBean {

    @Autowired
    private UserService userService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("-------------------定时任务开始执行-------------------");
        List<UserInfo> users = userService.getAllUserList();
        for (UserInfo user : users) {
            System.out.println(user);
        }
    }

}
