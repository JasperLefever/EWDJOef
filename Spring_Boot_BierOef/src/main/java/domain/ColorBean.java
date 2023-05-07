package domain;

import lombok.Getter;

import java.util.List;

@Getter
public class ColorBean {

	private final List<String> colorsList;

	public ColorBean() {
		colorsList = List.of("light", "brown", "dark");
	}

}