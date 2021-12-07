package com.cs.hcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*
(scanBasePackages = { "com.cs.hcm.config", "com.cs.hcm.controller", "com.cs.hcm.Entity",
		"com.cs.hcm.Mapper", "com.cs.hcm.Repository" ,"com.cs.hcm.service"})
*/
public class HcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmApplication.class, args);
	}

}
