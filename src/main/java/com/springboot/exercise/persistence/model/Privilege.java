package com.springboot.exercise.persistence.model;

import lombok.Data;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Data
@Entity
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    // A role can have multiple privileges and a privilege can be applied to several roles (many to many relationship)
    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege() {
        super();
    }

    public Privilege(final String name) {
        super();
        this.name = name;
    }
}

/*

    This class is to store the type of privileges a role can have
    For example, USER role can have the READ privilege or the ADMIN has the full privileges
    To store the privilege on the database, we need the following information:
        - id     (primary key)
        - name   (name of privilege, such as READ, WRITE, ...)

 */