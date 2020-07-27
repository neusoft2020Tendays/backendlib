package com.hitstu.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.hitstu.oa.hr.dao", "com.hitstu.oa.admin.dao"})
public class TenDaysNursingHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenDaysNursingHouseApplication.class, args);
	}

}
