package com.loabten.recipe.controllers;

import com.loabten.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String index(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
