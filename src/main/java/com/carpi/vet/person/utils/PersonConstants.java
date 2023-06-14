package com.carpi.vet.person.utils;

public final class PersonConstants {

    private PersonConstants(){}

    public interface User{
        String AUTH_BASIC = "basic";
        String AUTH_SOCIAL = "social";
    }

    public interface AuthErrors{
        String BAD_CREDENTIALS = "bad_credentials";
        String CAN_NOT_LOGIN_WITH_EMAIL = "can_not_login_with_email";
        String EMAIL_IS_NOT_REGISTERED = "email_is_not_registered";
    }
}
