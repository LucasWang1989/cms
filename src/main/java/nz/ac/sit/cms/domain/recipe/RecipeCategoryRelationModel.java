package nz.ac.sit.cms.domain.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @program: cms
 * @description: Provider data to front end.
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
@EqualsAndHashCode(callSuper=false)
public class RecipeCategoryRelationModel extends RecipeCategoryRelationEntity {
    private String categoryName;
}