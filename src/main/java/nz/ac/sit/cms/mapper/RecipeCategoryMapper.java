package nz.ac.sit.cms.mapper;

import nz.ac.sit.cms.domain.recipe.RecipeCategoryModel;
import nz.ac.sit.cms.domain.recipe.RecipeCategoryRelationModel;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @program: cms
 * @description: Mapper for table of RecipeCategory
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Mapper
public interface RecipeCategoryMapper {

    void addCategory(RecipeCategoryModel RecipeCategory);

    List<RecipeCategoryModel> acquireCategory();


}
