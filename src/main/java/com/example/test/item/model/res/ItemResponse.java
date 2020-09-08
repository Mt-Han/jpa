package com.example.test.item.model.res;

import com.example.test.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.ManyToOne;

@Data
@Getter
public class ItemResponse {
    private Long idx;
    private String name;
    private String value;
}
