package com.springboot.exercise.persistence.model;

import lombok.Data;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    // A role can be applied to several user and a user can have multiple roles (many to many relationship)
    @ManyToMany
    @JoinTable(name = "roles_privileges",
               joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    private String name;

    public Role() {
        super();
    }

    public Role(final String name) {
        super();
        this.name = name;
    }
}

/*

        This class is to store the Role types
        A user can have multiple roles for example, a user can be ADMIN, Maintainer, User, ...
        For storing role in database we need the following data:
            - id           (primary key)
            - name         (ADMIN, USER, MAINTAINER, ...)

       based on its id, we can make the join operation between tables

 */