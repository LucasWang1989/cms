package nz.ac.sit.cms.domain.recipe;

import lombok.Data;
import java.math.BigInteger;

/**
 * @program: cms
 * @description: Relationship between recipes and categories
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
public class RecipeCategoryRelationEntity {
    private static final long serialVersionUID = 1L;

    private String id;
    private Integer recipeId;
    private Integer categoryId;
    private String updateDate;
    private String createdDate;
}