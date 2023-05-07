package com.springBoot.productStart;

import domain.Price;
import domain.ProductManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import validator.PercentValidation;

@Controller
@RequestMapping("/increaseDecrease")
public class IncreaseDecreaseController {

    @Autowired
    private ProductManager productManager;

    @Autowired
    private PercentValidation percentValidation;


    @GetMapping
    public String showIncreaseDecrease(Model model) {
        Price price = new Price();
        price.setPercentDecrease(10);
        price.setPercentIncrease(20);
        model.addAttribute("price", price);
        return "priceChange";
    }

    @PostMapping
    public String increaseDecreasePrice(@Valid Price price, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        percentValidation.validate(price, result);

        if (result.hasErrors()) {
            return "priceChange";
        }

        productManager.increasePrice(price.getPercentIncrease());
        productManager.decreasePrice(price.getPercentDecrease());

        //return "redirect:/inventory";

        int verschil = price.getPercentIncrease() - price.getPercentDecrease();
        //return "redirect:/inventory?aangepast=" + verschil;


        redirectAttributes.addFlashAttribute("verschil", verschil);
        return "redirect:/inventory";
    }
}