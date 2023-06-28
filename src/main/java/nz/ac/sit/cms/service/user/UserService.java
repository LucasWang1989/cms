package nz.ac.sit.cms.service.user;

import nz.ac.sit.cms.common.security.TokenGenerator;
import nz.ac.sit.cms.domain.user.UserModel;
import nz.ac.sit.cms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * @program: os
 * @description: Management of users
 * @author: wangliang (Lucas Wang)
 * @email: lucas.wang.1024@gmail.com
 * @date: 2023-05-31 20:05
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public String validateCredentials(String username, String password) {
        Boolean isValid = false;

        UserModel user = userMapper.fetchUserByUsername(username);
        if(user != null) {
            isValid = user.getPassword().equals(password);
        }
        if (isValid) {
            return TokenGenerator.generateToken(username);
        } else {
            return "-1";
        }
    }

    public Boolean addUser(Map<String, String> userInf) {
        String userName = userInf.get("name");
        //Check if the username is exist.
        if(userMapper.fetchUserByUsername(userName) == null) {
            UserModel user = new UserModel();
            user.setUserName(userName);
            user.setPassword(userInf.get("password"));
            user.setEmail(userInf.get("email"));
            userMapper.addUser(user);
            return true;
        }
        return false;
    }
}