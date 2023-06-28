package nz.ac.sit.cms.domain.recipe;

import lombok.Data;

import java.util.List;

/**
 * @program: cms
 * @description: Provider data to front end.
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
public class RecipeModel extends RecipeEntity {

    private List<RecipeStepModel> recipeSteps;
    private List<RecipeCategoryRelationModel> recipeCategoryRelations;

}