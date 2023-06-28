package nz.ac.sit.cms.controller;

import nz.ac.sit.cms.domain.recipe.RecipeCategoryModel;
import nz.ac.sit.cms.mapper.RecipeCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @program: cms
 * @description: Operation for category
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-28 13:25
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private RecipeCategoryMapper recipeCategoryMapper;

    @RequestMapping("/fetch-category")
    public List<RecipeCategoryModel> fetchCategory() {
        return recipeCategoryMapper.acquireCategory();
    }
}