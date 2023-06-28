package nz.ac.sit.cms.mapper;

import nz.ac.sit.cms.domain.recipe.RecipeModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cms
 * @description: Mapper for table of recipes
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Mapper
public interface RecipeMapper {

    void addRecipe(RecipeModel recipe);

    List<RecipeModel> fetchRecipeByKeyword(@Param("keyWord") String keyWord);

    List<RecipeModel> fetchRecipe();

    List<RecipeModel> fetchRecipeByUsername(@Param("username") String username);
}
