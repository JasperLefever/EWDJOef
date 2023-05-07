package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BeerExpertTest {

	private ExpertBean beerExpert;

	private static List<String> 
	        resultLight = List.of("Hoegaarden", "Brugs Witbier" ),
			resultBrown = List.of("Westmalle bruin", "Leffe bruin"),
			resultDark = List.of("Affligem Donker" ),
			resultEmpty = new ArrayList<>();

	@BeforeEach
	public void before() {
		beerExpert = new BeerExpertBean();
	}

	@ParameterizedTest
	@MethodSource("addFixture")
	public void add(String input, List<String> expResult) {
		Assertions.assertEquals(expResult, beerExpert.getExpert(input));
	}

	private static Stream<Arguments> addFixture() {
		return Stream.of(
				Arguments.of("light", resultLight), 
				Arguments.of("brown", resultBrown),
				Arguments.of("dark", resultDark), 
				Arguments.of("LIGHT", resultLight),
				Arguments.of("Brown", resultBrown), 
				Arguments.of("DaRk", resultDark),
				Arguments.of("  light    ", resultLight), 
				Arguments.of("l ight", resultEmpty),
				Arguments.of(null, resultEmpty), 
				Arguments.of("", resultEmpty), 
				Arguments.of("    ", resultEmpty),
				Arguments.of("abc", resultEmpty));
	}

}
