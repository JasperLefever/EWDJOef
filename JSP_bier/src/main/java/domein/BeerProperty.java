package domein;

import java.util.List;

public class BeerProperty {

    private final List<String> colors;

    public BeerProperty()
    {
        colors = List.of("light", "brown", "dark");
    }
    public List<String> getColors() {
        return colors;
    }

}
