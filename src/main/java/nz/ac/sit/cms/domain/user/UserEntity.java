package nz.ac.sit.cms.domain.user;

import lombok.Data;

/**
 * @program: cms
 * @description: Recipe information
 * @author: wangliang
 * @date: 2023-05-24 14:19
 **/
@Data
public class UserEntity {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String updateDate;
    private String createdDate;
}