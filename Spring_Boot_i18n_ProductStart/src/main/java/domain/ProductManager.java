package domain;

import java.util.List;

public interface ProductManager {

    public void increasePrice(int percentage);

    public void decreasePrice(int percentage);
    
    public List<Product> getProducts();
}