package nz.ac.sit.cms.mapper;

import nz.ac.sit.cms.domain.recipe.RecipeCategoryRelationModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cms
 * @description: Mapper for table of RecipeCategoryRelation
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Mapper
public interface RecipeCategoryRelationMapper {

    void addRecipeCategoryRelation(RecipeCategoryRelationModel recipeCategoryRelation);

//    void updateRecipeCategoryRelation(RecipeCategoryRelationModel recipeCategoryRelation);

    List<RecipeCategoryRelationModel> acquireCategoryByRecipeId(@Param("recipeId") Integer recipeId);
//
//    List<RecipeCategoryRelationModel> acquireRecipeByCategoryId(RecipeCategoryRelationModel recipeCategoryRelation);

}
