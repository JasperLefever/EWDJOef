package perform;

import java.util.stream.IntStream;

import org.springframework.web.reactive.function.client.WebClient;

import domain.Fruit;
import reactor.core.publisher.Mono;

import static utils.InitFormatter.*;

public class PerformRestFruit {

	private final String SERVER_URI = "http://localhost:8080/fruit";
	private WebClient webClient = WebClient.create();

	public PerformRestFruit() {
		IntStream.rangeClosed(1, 3).forEach(number -> {
			try
			{
				System.out.printf("------- GET %d ------- %n", number);
				getFruit(number);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		});

		System.out.println("\n------- GET ALL -------");
		getAllFruits();
	}

	private void getFruit(int number) {
		webClient.get()
	    .uri(SERVER_URI + "/" + number)
	    .retrieve()
	    .bodyToMono(Fruit.class)
	    .doOnSuccess(fruit -> printFruitData(fruit))
	    .block();
	}

	private void getAllFruits() {
		webClient.get().uri(SERVER_URI + "/all").retrieve()
        .bodyToFlux(Fruit.class)
        .flatMap(fruit -> {
            printFruitData(fruit);
            return Mono.empty();
        })
        .blockLast();
	}
	
	private void printFruitData(Fruit fruit) {
		System.out.printf("ID=%s, Name=%s, Quality=%s%n", fruit.getId(), fruit.getName(), 
				FORMATTER.format(fruit.getQuality()));
	}
	
}
