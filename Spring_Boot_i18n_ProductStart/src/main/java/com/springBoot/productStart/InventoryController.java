package com.springBoot.productStart;

import domain.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class InventoryController  {


    @Autowired
    private ProductManager productManager;

    @GetMapping
    public String showInventory(Model model) {
        model.addAttribute("productList", productManager.getProducts());
        return "productOverview";
    }
}