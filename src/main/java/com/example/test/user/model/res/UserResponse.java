package com.example.test.user.model.res;
import com.example.test.item.model.Item;
import com.example.test.user.model.User;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class UserResponse {

        private Long idx;

        private Date createDt;

        private Date updateDt;

        private String userId;

        private String name;

        private User.genderType gender;

        private int age;

        private List<Item> items;
}
