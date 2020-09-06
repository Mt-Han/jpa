package com.example.test.user.model.req;

import com.example.test.user.model.User;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class UserRequest {

    private Long idx;

    private Date createDt;

    private Date updateDt;

    private String userId;

    private String password;

    private String name;

    private User.genderType gender;

    private int age;
}
