package project_part2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Program {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(Test.class, args); 
		
		/*
		Test test = new Test();
		test.testAll(args);
		*/
	}
}
