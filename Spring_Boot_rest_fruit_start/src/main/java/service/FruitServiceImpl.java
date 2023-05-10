package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Fruit;
import exceptions.FruitNotFoundException;

public class FruitServiceImpl implements FruitService{

    private final Map<Integer, Fruit> fruitMap = new HashMap<>();
    
    public FruitServiceImpl()
    {
        fruitMap.put(1, new Fruit(1, "orange", 5.213));
        fruitMap.put(2, new Fruit(2, "strawberry", 6.789));
    }
    
    @Override
    public Fruit getFruitDetail(int id) {
        Fruit fruit = fruitMap.get(id);
        if (fruit == null)
        	throw new FruitNotFoundException(id);
        return fruit;
    }
    
    @Override
    public List<Fruit> getAllFruits() {
        return fruitMap.values().stream().collect(Collectors.toUnmodifiableList());
    }
    
}
