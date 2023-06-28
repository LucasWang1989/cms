package nz.ac.sit.cms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import nz.ac.sit.cms.domain.recipe.RecipeCategoryRelationModel;
import nz.ac.sit.cms.domain.recipe.RecipeModel;
import nz.ac.sit.cms.domain.recipe.RecipeStepModel;
import nz.ac.sit.cms.service.recipe.RecipeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: cms
 * @description: Operation about recipe
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-26 13:30
 **/
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping("/fetch-recipe")
    public List<RecipeModel> fetchRecipe(@RequestBody String keyWord) {
        if(StringUtils.isNotEmpty(keyWord)) {
            JSONObject jo = JSONObject.parseObject(keyWord);
            keyWord = (String)jo.get("keyWord");
        }
        return recipeService.fetchRecipe(keyWord);
    }

    @RequestMapping("/create-recipe")
    public String createRecipe(@RequestBody String data) {
        try {
            // Assemble recipe object.
            JSONObject jo = JSON.parseObject(data);
            RecipeModel recipe = new RecipeModel();
            recipe.setTitle((String)jo.get("title"));
            recipe.setIngredients((String)jo.get("mainIngredients"));
            recipe.setSubIngredients((String)jo.get("subIngredients"));
            recipe.setIntro((String)jo.get("introduction"));
            recipe.setCoverPageUrl((String)jo.get("coverImage"));
            recipe.setCoverVideoUrl((String)jo.get("recipeVideo"));
            recipe.setMediaType((Boolean)jo.get("isVideo") ? "1" : "0");
            recipe.setUsername(jo.getString("username"));

            // Assemble object of relationship between recipe and category.
            JSONArray jaCategories = JSON.parseArray(JSON.toJSONString(jo.get("selectedCategories")));
            List<RecipeCategoryRelationModel> recipeCategoryRelations = new ArrayList<>();
            for (int i = 0; i < jaCategories.size(); i++) {
                RecipeCategoryRelationModel recipeCategoryRelation = new RecipeCategoryRelationModel();
                recipeCategoryRelation.setCategoryId(jaCategories.getInteger(i));
                recipeCategoryRelations.add(recipeCategoryRelation);
            }
            recipe.setRecipeCategoryRelations(recipeCategoryRelations);

            // Assemble recipe step object.
            JSONArray jaSteps = JSON.parseArray(JSON.toJSONString(jo.get("steps")));
            List<RecipeStepModel> recipeSteps = new ArrayList<>();
            for (int i = 0; i < jaSteps.size(); i++) {
                JSONObject joStep = jaSteps.getJSONObject(i);

                RecipeStepModel recipeStep = new RecipeStepModel();
                recipeStep.setStepImgUrl((String)joStep.get("image"));
                recipeStep.setStepContent((String)joStep.get("description"));
                recipeStep.setStepOrder((String)joStep.get("order"));
                recipeSteps.add(recipeStep);
            }
            recipe.setRecipeSteps(recipeSteps);

            // Persist data.
            Integer recipeId = recipeService.createRecipe(recipe);

            return recipeId.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}