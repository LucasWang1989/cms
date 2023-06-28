package nz.ac.sit.cms.controller;

import nz.ac.sit.cms.common.security.TokenGenerator;
import nz.ac.sit.cms.domain.recipe.RecipeModel;
import nz.ac.sit.cms.service.recipe.RecipeService;
import nz.ac.sit.cms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cms
 * @description: Operation for user
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-31 13:25
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {

        String username = credentials.get("username");
        String password = credentials.get("password");
        Assert.hasText(username, "Username is empty");
        Assert.hasText(password, "Password is empty");

        String token = userService.validateCredentials(username, password);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return response;

    }

    @RequestMapping("/add-user")
    public Map<String, String> addProduct(@RequestBody Map<String, String> userInf) {
        String username = userInf.get("name");
        String password = userInf.get("password");
        String email = userInf.get("email");
        Assert.hasText(username, "Username is empty");
        Assert.hasText(password, "Password is empty");
        Assert.hasText(email, "Email is empty");

        Map<String, String> response = new HashMap<>();
        if(userService.addUser(userInf)) {
            response.put("status", "success");
            response.put("msg", "Register Successfully.");
            return response;
        }
        response.put("status", "fail");
        response.put("msg", "The user ["+ username +"] already exists.");
        return response;
    }

    @RequestMapping("/check-token")
    public String checkToken(@RequestBody Map<String, String> credentials) {
        String token = credentials.get("token");
        Assert.hasText(token, "Token is empty");
        String username = credentials.get("username");
        Assert.hasText(username, "User name is empty");

        return username.equals(TokenGenerator.validateToken(token)) ?  "success" : "fail";
    }

    @RequestMapping("/fetch-my-upload")
    public List<RecipeModel> fetchMyUpload(@RequestParam String username) {
        Assert.hasText(username, "Username is empty");
        return recipeService.fetchRecipeByUsername(username);
    }
}