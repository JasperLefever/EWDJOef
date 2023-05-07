package domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SimpleProductManager implements ProductManager {
		
    private List<Product> products;

    @Override
    public void increasePrice(int percentage) {
    	if (products != null) {
    		products = products.stream()
                .map(p -> p.toBuilder()
                        .price(p.getPrice() * (1 + percentage / 100.))
                        .build())
                .toList();
    	}
    }

    @Override
    public void decreasePrice(int percentage) {
    	if (products != null) {
    		products = products.stream()
                .map(p -> p.toBuilder()
                        .price(p.getPrice() * (1 - percentage / 100.))
                        .build())
                .toList();
    	}
    }
}