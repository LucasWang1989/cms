package nz.ac.sit.cms.domain.recipe;

import lombok.Data;
import java.math.BigInteger;

/**
 * @program: cms
 * @description: Recipe information
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
public class RecipeEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String intro;
    private String ingredients;
    private String subIngredients;
    private String coverPageUrl;
    private String coverVideoUrl;
    private String mediaType;
    private String username;
    private String updateDate;
    private String createdDate;
}