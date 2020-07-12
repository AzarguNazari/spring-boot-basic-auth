package com.springboot.exercise.persistence.model;

import com.springboot.exercise.web.util.Utils;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Column(length = 60)
    private String password;

    private boolean enabled;

    private boolean isUsing2FA;

    private String secret;

    // a user can have multiple roles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
               joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
        super();
        this.secret = Utils.generateBase32();
        this.enabled = false;
    }
}

/*
    This class is to store the user information on the persistence layer.
    A user has the following information while storing on databse:
        - id (primary key)
        - first name
        - last name
        - email
        - password
        - enable (activated or not)
        - isUsing2FA  (is based on 32 secret)
        - secret (secret based on 32 length)
        - roles
 */