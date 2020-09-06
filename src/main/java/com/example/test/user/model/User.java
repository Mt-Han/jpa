package com.example.test.user.model;

import com.example.test.common.BaseEntity;
import com.example.test.item.model.Item;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="user" ,
        uniqueConstraints={
                @UniqueConstraint(name = "user_id_name",columnNames={"userId","name"})
        }
)
public class User extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long idx;

    private String userId;

    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum ('MAN','GIRL')")
    private genderType gender;

    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Item> items;

    public enum genderType {
        MAN,
        GIRL
    }
}
