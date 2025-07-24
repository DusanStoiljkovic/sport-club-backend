package com.singidunum.sports_club_backend.exceptions.user;

import com.singidunum.sports_club_backend.exceptions.BaseException;

public class UserAlreadyExistException extends BaseException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
