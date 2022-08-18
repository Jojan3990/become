package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

//@Getter //this is lombock dependency
//@Setter

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//relies on autoincremented database column and lets database generate new value with each insert opetaion.
    @SequenceGenerator( //increment value everytime table is updated
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="role_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles")//here Role id PK is referring to FK of user_id table i.e:- rold_id
    private Set<User> users;
}
