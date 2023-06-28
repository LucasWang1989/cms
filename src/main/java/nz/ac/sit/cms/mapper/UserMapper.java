package nz.ac.sit.cms.mapper;

import nz.ac.sit.cms.domain.user.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cms
 * @description: Mapper for table of user
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Mapper
public interface UserMapper {

    void addUser(UserModel user);

    UserModel fetchUserByUsername(@Param("userName") String username);
}
