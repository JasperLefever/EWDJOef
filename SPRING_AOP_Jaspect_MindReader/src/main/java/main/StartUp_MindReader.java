package main;

import configuration.BeanConfiguration;
import domain.MindReader;
import domain.Thinker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartUp_MindReader {

	public static void main(String args[])
    {
			try (var context = new AnnotationConfigApplicationContext(BeanConfiguration.class)) {

				var thinker = context.getBean(Thinker.class);

				var mindReader = context.getBean(MindReader.class);

				thinker.thinkOfSomething("Queen of Hearts");

				System.out.println(mindReader.getThoughts());
		    }
	}
}