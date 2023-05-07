package main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.FirstExampleConfiguration;
import spring_wiring.CalculateSpring;

public class StartUp {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(FirstExampleConfiguration.class)) {
			
			var opsbean = context.getBean("opsbean", CalculateSpring.class);

			opsbean.execute(args);
		}
	}
}