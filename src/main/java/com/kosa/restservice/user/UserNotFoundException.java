package com.kosa.restservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//2XX -> OK
//4XX -> Client Error
//5XX -> Server Error
//@ResponseStatus(HttpStatus.NOT_FOUND)로 404를 띄워준다.
//HttpStatus.INTERNAL_SERVER_ERROR 500 Error
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
