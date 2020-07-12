package com.springboot.exercise.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24; // = one day

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    public PasswordResetToken() {
        super();
    }

    public PasswordResetToken(final String token) {
        super();

        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public PasswordResetToken(final String token, final User user) {
        super();
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    public void updateToken(final String token) {
        this.token = token;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
}

/*

    This class is to store the reset time of user password
    A password token expires within one day if the user doesn't change the password
    To store the password token expiration, we need the following information:
        - id      (primary key)
        - token   (token)
        - expiryData   (the date of expiration)

    For every token reset expiration, only one user can have and one use can only have one reset token at a time

 */