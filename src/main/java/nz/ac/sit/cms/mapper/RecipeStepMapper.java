package nz.ac.sit.cms.mapper;

import nz.ac.sit.cms.domain.recipe.RecipeStepModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cms
 * @description: Mapper for table of recipe steps
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Mapper
public interface RecipeStepMapper {
    void addRecipeStep(List<RecipeStepModel> recipeStep);

    List<RecipeStepModel> fetchRecipeSteps(@Param("recipeId") Integer recipeId);

}
