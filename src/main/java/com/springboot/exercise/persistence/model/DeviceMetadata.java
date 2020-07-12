package com.springboot.exercise.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class DeviceMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    private String deviceDetails;
    private String location;
    private Date lastLoggedIn;
}

/*

    This class is to store the Device information details
    The purpose of this class is for the analytics reason, the received information from client devices can determine the type of services to be provided
    To store the device meta information on database we need the following information:
        - id                    (primary key)
        - userID                (user id which accesses)
        - deviceDetails         (details about device)
        - location              (location of accessed)
        - lastLoggedIn          (last time logged)

 */