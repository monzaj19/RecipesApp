package org.recipes.app.recipesapp.controller;

import org.recipes.app.recipesapp.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<String> getRecipes(@RequestParam String query) {
        String response = recipeService.getRecipes(query);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<String> getRecipeById(@PathVariable String id) {
        String response = recipeService.getRecipeById(id);
        return ResponseEntity.ok(response);
    }
}
