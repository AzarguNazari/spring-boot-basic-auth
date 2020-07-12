package com.springboot.exercise.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}