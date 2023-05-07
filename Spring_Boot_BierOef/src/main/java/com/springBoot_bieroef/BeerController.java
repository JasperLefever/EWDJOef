package com.springBoot_bieroef;

import domain.ColorBean;
import domain.ExpertBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/beer")
public class BeerController {

    @Autowired
    private ExpertBean expertBean;

    @GetMapping
    public String showHomePage(Model model) {
        /*ColorBean colorBean = new ColorBean();
        model.addAttribute("colorList", colorBean.getColorsList());
        zelfde als @ModelAttribute("colorList")
        */

        model.addAttribute("beerCommand", new BeerCommand());//opslaan van gekozen kleur
        return "formView";
    }

    @ModelAttribute("colorList")
    public List<String> pupulateColorList() {
        ColorBean colorBean = new ColorBean();
        return colorBean.getColorsList();
    }

    @PostMapping
    public String onSubmit(BeerCommand beerCommand, Model model) {
        model.addAttribute("listBeer", expertBean.getExpert(beerCommand.getColorSelected()));
        return "resultView";
    }
}
