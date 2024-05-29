package org.recipes.app.recipesapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecipeService {
    private static final String BASE_URL = "https://api.spoonacular.com/recipes/";
    private final RestTemplate restTemplate;

    @Value("${spoonacular.api.key}")
    private final String apiKey;

    public RecipeService(RestTemplateBuilder restTemplateBuilder, @Value("${spoonacular.api.key}") String apiKey) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = apiKey;
    }

    public String getRecipes(String query) {
        String url = BASE_URL + "complexSearch?apiKey=" + apiKey + "&query=" + query;
        return restTemplate.getForObject(url, String.class);
    }
}
