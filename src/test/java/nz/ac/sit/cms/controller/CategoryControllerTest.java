package nz.ac.sit.cms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @program: cms
 * @description:
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-28 15:11
 **/
@SpringBootTest
class CategoryControllerTest {
    @Autowired
    private CategoryController categoryController;


    @Test
    void fetchCategory() {

        categoryController.fetchCategory();
    }
}