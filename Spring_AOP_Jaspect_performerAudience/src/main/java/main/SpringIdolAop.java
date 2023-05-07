package main;
import configuration.BeanConfiguration;
import domain.Performer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIdolAop {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(BeanConfiguration.class)) {

			var performer = context.getBean("alicia", Performer.class);
			performer.perform();
			System.out.println("-----------------------------");

			var performer2 = context.getBean("mika", Performer.class);
			performer2.perform();
			System.out.println("-----------------------------");

			var performer3 = context.getBean("shakira", Performer.class);
			performer3.perform();
			System.out.println("-----------------------------");
		}
	}
}