package com.carpi.vet.utils;

public final class ErrorConstants {

    private ErrorConstants(){}

    public interface SqlError{
        String DUPLICATE_FIELD = "duplicate_field";
    }

    public interface SqlErrorCode{
        int DUPLICATE_FIELD = 1062;
    }

    public interface SocialError{
        String TOKEN_INVALID = "token_invalid";
    }

}
