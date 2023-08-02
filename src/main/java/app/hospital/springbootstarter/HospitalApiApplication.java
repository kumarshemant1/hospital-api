package app.hospital.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = "app.hospital.*") //defined as other components are not placed under 1 package
public class HospitalApiApplication {

	public static void main(String[] args) {
		log.info("------------------Success");
		SpringApplication.run(HospitalApiApplication.class, args);

	}

}
