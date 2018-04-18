package com.zby.scheduler;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class HelloWorldJob extends QuartzJobBean {
	private String triggerData;
	private Long longData;
	private ApplicationContext applicationContext;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("triggerData:"+triggerData);
		System.out.println("longData:"+longData);
		System.out.println("applicationContext:"+applicationContext.getDisplayName());
	}
	public void setTriggerData(String triggerData) {
		this.triggerData = triggerData;
	}
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	public void setLongData(Long longData) {
		this.longData = longData;
	}
}
