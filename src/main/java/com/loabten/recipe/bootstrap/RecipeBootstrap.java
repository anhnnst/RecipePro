package com.loabten.recipe.bootstrap;

import com.loabten.recipe.domain.*;
import com.loabten.recipe.repositories.CategoryRepository;
import com.loabten.recipe.repositories.RecipeRepository;
import com.loabten.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("Bootstrap data");

        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        //get UOMs
        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        //get UOMs
        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        //get UOMs
        if (!teaspoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        //get UOMs
        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        //get UOMs
        if (!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        //get UOMs
        if (!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        }

        //get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        //get categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Yummy Guac
        Recipe quacRecipe = new Recipe();
        quacRecipe.setDescription("Perfect Guacamole");
        quacRecipe.setPrepTime(10);
        quacRecipe.setCookTime(0);
        quacRecipe.setDifficulty(Difficulty.EASY);
        quacRecipe.setDirections("I cut avocado.");

        Notes quacNotes = new Notes();
        quacNotes.setRecipeNotes("For a very quick quacamole");
        quacRecipe.setNotes(quacNotes);

        if (quacRecipe.getIngredients()== null) quacRecipe.setIngredients(new HashSet<>());
        quacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        quacRecipe.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(.5), teaspoonUom));
        quacRecipe.getIngredients().add(new Ingredient("fresh line juice or lemon juice", new BigDecimal(2), tablespoonUom));
        quacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), eachUom));
        quacRecipe.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), tablespoonUom));
        quacRecipe.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), dashUom));
        quacRecipe.getIngredients().add(new Ingredient("Freshly grated black pepper", new BigDecimal(.5), eachUom));
        quacRecipe.getIngredients().add(new Ingredient("ripe tomoto, seeds and pulp removed, chopped", new BigDecimal(.5), eachUom));

        if (quacRecipe.getCategories()==null) quacRecipe.setCategories(new HashSet<>());
        quacRecipe.getCategories().add(americanCategory);
        quacRecipe.getCategories().add(americanCategory);

        //add to return list
        recipes.add(quacRecipe);

        return recipes;
    }


}
