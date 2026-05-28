package lk.ijse.AAD_75;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration - mark as a config class
//@ComponentScan - find all the controllers and services automatically//
//@EnableAutoConfiguration - Spring automatically configures dependencies
@SpringBootApplication
public class Aad75Application {

	public static void main(String[] args) {
		// .run command starts our application
		SpringApplication.run(Aad75Application.class, args);
	}

}
