package domein;

import java.util.ArrayList;
import java.util.List;

public class BeerExpertBean {

    public List<String> getBrands(String color) {
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
