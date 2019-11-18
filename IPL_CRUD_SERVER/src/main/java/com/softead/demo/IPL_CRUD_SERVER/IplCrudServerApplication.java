package com.softead.demo.IPL_CRUD_SERVER;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
//@SpringBootApplication
@SpringBootApplication(scanBasePackages={"com.softead.demo.IPL_CRUD_SERVER.player", "com.softead.demo.IPL_CRUD_SERVER.team"})
public class IplCrudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplCrudServerApplication.class, args);
	}

}
