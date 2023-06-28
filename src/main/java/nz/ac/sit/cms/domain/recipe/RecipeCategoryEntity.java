package nz.ac.sit.cms.domain.recipe;

import lombok.Data;

/**
 * @program: cms
 * @description: Category information
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
public class RecipeCategoryEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String updateDate;
    private String createdDate;

}