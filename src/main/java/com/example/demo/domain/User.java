package com.example.demo.domain;


//    @SequenceGenerator(
//            name="user_sequence",
//            sequenceName = "user_sequence",
//            allocationSize = 1
//    )
//        @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,generator = "user_sequence"
//    )
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Getter //this is third party lombock dependency
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_main",
        schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)//as user is reserved keyword public means anyone can access this role
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//defines how to generate value from given column
    private Long id;

    @Column(nullable = false)//this means that if hibernate creates databse schema auomatically not null constraint is specified
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String username;

    @ManyToMany(
            cascade = CascadeType.ALL
    ) //here user id PK is referring to FK of user_role table i.e user_id
    @JoinTable(name="user_role", //junction table
        joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),//here the id is of this User class int id
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles=new HashSet<>();//one use can have multiple roles,



//    private List<Role> roles;//one use can have multiple roles
    //Set<> is a collection that cannot contain duplicate elements
    //HashSet used to create a collection that uses hash table for storage.
    //this inherits AbstractSet class and implements set interface. it contains unique element only. this allows null value
    //hashCode() created unique hash value of element if hash value mathces it doesn store in set


}
