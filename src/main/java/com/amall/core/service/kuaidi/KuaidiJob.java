package com.amall.core.service.kuaidi;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class KuaidiJob implements Job
{

	@Override
	public void execute (JobExecutionContext job) throws JobExecutionException
		{
			JobDataMap data = job.getJobDetail ().getJobDataMap ();
			System.out.println ("正在重新订阅运单号:" + data.get ("number").toString ());
			// kuaiDi100Helper.kuaidiTake(data.get("company").toString(),null,null,
			// data.get("number").toString());
		}
}
