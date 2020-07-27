package com.hitstu.oa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hitstu.oa.checkin.model.ElderlyModel;
import com.hitstu.oa.checkin.service.IElderlyService;
import com.hitstu.oa.config.SpringConfigForSM;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigForSM.class);
		IElderlyService elderlyService = context.getBean("elderlyService", IElderlyService.class);
		ElderlyModel elderlyModel = new ElderlyModel();
		elderlyModel.setElderlyId("1");
		elderlyModel.setAge(80);
		elderlyModel.setSex("M");
		try {
			elderlyService.add(elderlyModel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
