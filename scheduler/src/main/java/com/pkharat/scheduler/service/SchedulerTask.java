package com.pkharat.scheduler.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
	@Scheduled(fixedRate = 2000)
	public void currenttime() {
		System.out.println("Current Time:>"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
	}

}
