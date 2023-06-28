package nz.ac.sit.cms.service.recipe;

import nz.ac.sit.cms.common.util.DateUtil;
import nz.ac.sit.cms.domain.recipe.RecipeCategoryRelationModel;
import nz.ac.sit.cms.domain.recipe.RecipeModel;
import nz.ac.sit.cms.domain.recipe.RecipeStepModel;
import nz.ac.sit.cms.mapper.RecipeCategoryRelationMapper;
import nz.ac.sit.cms.mapper.RecipeMapper;
import nz.ac.sit.cms.mapper.RecipeStepMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: cms
 * @description: Operation about recipe
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-26 13:30
 **/
@Service
public class RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;
    @Autowired
    private RecipeStepMapper recipeStepMapper;
    @Autowired
    private RecipeCategoryRelationMapper recipeCategoryRelationMapper;

    public List<RecipeModel> fetchRecipe(String keyWord) {
        List<RecipeModel> recipes = new ArrayList<>();
        if(StringUtils.isNotEmpty(keyWord)) {
            recipes = recipeMapper.fetchRecipeByKeyword(keyWord);
        }else {
            recipes = recipeMapper.fetchRecipe();
        }

        // Fill up step and category data for each recipe.
        recipes.stream().forEach(recipe -> {
            List<RecipeStepModel> recipeSteps = recipeStepMapper.fetchRecipeSteps(recipe.getId());
            recipe.setRecipeSteps(recipeSteps);

            List<RecipeCategoryRelationModel> recipeCategoryRelations = recipeCategoryRelationMapper.acquireCategoryByRecipeId(recipe.getId());
            recipe.setRecipeCategoryRelations(recipeCategoryRelations);
        } );

        return recipes;
    }

    @Transactional
    public Integer createRecipe(RecipeModel recipe) {

        // Create main recipe records.
        recipe.setUpdateDate(DateUtil.getDateTime2());
        recipe.setCreatedDate(DateUtil.getDateTime2());
        recipeMapper.addRecipe(recipe);

        // Acquire recipe ID.
        Integer recipeId = recipe.getId();

        // Create recipe step records.
        List<RecipeStepModel> recipeSteps = recipe.getRecipeSteps();
        for(RecipeStepModel recipeStep : recipeSteps) {
            recipeStep.setRecipeId(recipeId);
            recipeStep.setUpdateDate(DateUtil.getDateTime2());
            recipeStep.setCreatedDate(DateUtil.getDateTime2());
        }
        recipeStepMapper.addRecipeStep(recipeSteps);

        //Create relationship between recipe and  category records.
        List<RecipeCategoryRelationModel> recipeCategoryRelations = recipe.getRecipeCategoryRelations();
        for(RecipeCategoryRelationModel recipeCategoryRelation : recipeCategoryRelations) {
            recipeCategoryRelation.setRecipeId(recipeId);
            recipeCategoryRelation.setUpdateDate(DateUtil.getDateTime2());
            recipeCategoryRelation.setCreatedDate(DateUtil.getDateTime2());
            recipeCategoryRelationMapper.addRecipeCategoryRelation(recipeCategoryRelation);
        }

        return recipeId;
    }

    public List<RecipeModel> fetchRecipeByUsername(String username) {
        List<RecipeModel> recipes = new ArrayList<>();
        recipes.addAll(recipeMapper.fetchRecipeByUsername(username));

        // Fill up step and category data for each recipe.
        recipes.forEach(recipe -> {
            List<RecipeStepModel> recipeSteps = recipeStepMapper.fetchRecipeSteps(recipe.getId());
            recipe.setRecipeSteps(recipeSteps);

            List<RecipeCategoryRelationModel> recipeCategoryRelations = recipeCategoryRelationMapper.acquireCategoryByRecipeId(recipe.getId());
            recipe.setRecipeCategoryRelations(recipeCategoryRelations);
        } );

        return recipes;
    }
}