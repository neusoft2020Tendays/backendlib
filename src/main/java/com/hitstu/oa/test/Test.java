package com.hitstu.oa.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hitstu.oa.checkin.model.BedModel;
import com.hitstu.oa.checkin.service.IBedService;
import com.hitstu.oa.config.SpringConfigForSM;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigForSM.class);
		IBedService bedService = context.getBean(IBedService.class);

		try {
			List<BedModel> list = bedService.getByAllWithPage(3, 3);
			for (BedModel bedModel : list) {
				System.out.println(bedModel.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
