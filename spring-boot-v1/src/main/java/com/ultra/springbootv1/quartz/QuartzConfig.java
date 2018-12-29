package com.ultra.springbootv1.quartz;

import com.ultra.springbootv1.quartz.task.UserTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @Author: ZhaoJP
 * @Date: 2018/12/27
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail userTaskDetail() {
        return JobBuilder
                .newJob(UserTask.class)
                .withIdentity("userTask")
                .storeDurably()
                .build();
    }

/*    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("1/5 * * * * ?");
        return TriggerBuilder
                .newTrigger()
                .forJob(userTaskDetail())
                .withIdentity("userTask")
                .withSchedule(scheduleBuilder)
                .build();
    }*/

/*  "0 0 12 * * ?" 每天中午12点触发
 	"1/30 * * * * ?"  每30秒更新一次
	"0 15 10 ? * *" 每天上午10:15触发
	"0 15 10 * * ?" 每天上午10:15触发
	"0 15 10 * * ? *" 每天上午10:15触发
	"0 15 10 * * ? 2005" 2005年的每天上午10:15触发
	"0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
	"0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
	"0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
	"0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
	"0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
	"0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
	"0 15 10 15 * ?" 每月15日上午10:15触发
	"0 15 10 L * ?" 每月最后一日的上午10:15触发
	"0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
	"0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
	"0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发*/

}
