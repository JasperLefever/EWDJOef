package domain;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class BeerExpertBean implements ExpertBean {

	@Override
	public List<String> getExpert(String color) {
		if (color == null)
			return new ArrayList<>();

		return switch (color.toLowerCase().trim()) {
		case "light" -> List.of("Hoegaarden", "Brugs Witbier");
		case "brown" -> List.of("Westmalle bruin", "Leffe bruin");
		case "dark" -> List.of("Affligem Donker");
		default -> new ArrayList<>();
		};
	}
}
