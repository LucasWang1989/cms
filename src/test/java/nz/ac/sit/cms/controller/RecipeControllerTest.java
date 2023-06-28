package nz.ac.sit.cms.controller;

import nz.ac.sit.cms.domain.recipe.RecipeModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: os
 * @description:
 * @author: wangliang
 * @date: 2022-10-24 15:04
 **/
@SpringBootTest
class RecipeControllerTest {
    @Autowired
    private RecipeController recipeController;

    @Test
    void fetchRecipe() {
        List<RecipeModel> recipes = recipeController.fetchRecipe(null);

        System.out.println(recipes);
    }

}