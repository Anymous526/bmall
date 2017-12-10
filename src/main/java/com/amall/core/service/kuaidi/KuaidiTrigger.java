package com.amall.core.service.kuaidi;

import java.util.Calendar;
import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class KuaidiTrigger {

	public static void begin(String company,String number ) {
		try {
			JobDetail jd = new JobDetail("kuaidi_job", "kuaidi_group",
					KuaidiJob.class);
			JobDataMap data = jd.getJobDataMap();
			data.put("company", company);
			data.put("number",number);
			SimpleTrigger trigger = new SimpleTrigger("kuaidi_job",
					"kuaidi_group");
			Calendar cal = Calendar.getInstance();
			//15分钟后
			cal.add(Calendar.MINUTE, 1);
			Date date = cal.getTime();
			trigger.setStartTime(date);
			trigger.setRepeatCount(1);
			trigger.setRepeatInterval(5000);
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jd, trigger); //注册并进行调度
			scheduler.start();  //调度启动
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		begin("bbbb", "8014");
	}

}
