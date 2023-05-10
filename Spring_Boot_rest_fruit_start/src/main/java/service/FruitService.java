package service;

import java.util.List;

import domain.Fruit;

public interface FruitService {

    public Fruit getFruitDetail(int id);
    
    public List<Fruit> getAllFruits();
}
