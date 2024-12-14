package com.app.backend;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.OFF);
		builder.profiles("development");
		builder.run(args);
	}

}
