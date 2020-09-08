package com.example.test.item.model.req;

import com.example.test.user.model.User;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ItemRequest {
    private Long idx;
    private String name;
    private String value;
}
