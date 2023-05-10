package com.springboot.restFruitStart;

import java.util.List;
import domain.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FruitService;

@RestController
@RequestMapping("/fruit")
public class FruitRestController {

    @Autowired
    private FruitService fruitService;

    @RequestMapping("/{fruitId}")
    public Fruit getFruitDetail(@PathVariable int fruitId) {
        return fruitService.getFruitDetail(fruitId);
    }

    @RequestMapping("/all")
    public List<Fruit> getAllFruits() {
        return fruitService.getAllFruits();
    }
}
