package nz.ac.sit.cms.domain.recipe;

import lombok.Data;
import java.math.BigInteger;

/**
 * @program: cms
 * @description: Recipe Step information
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
public class RecipeStepEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer recipeId;
    private String stepImgUrl;
    private String stepContent;
    private String stepOrder;
    private String updateDate;
    private String createdDate;
}