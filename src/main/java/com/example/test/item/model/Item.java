package com.example.test.item.model;


import com.example.test.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="item")
public class Item {
    @Id
    private Long idx;

    private String name;
    private String value;

    @ManyToOne
    @JsonIgnore
    private User user;
}
