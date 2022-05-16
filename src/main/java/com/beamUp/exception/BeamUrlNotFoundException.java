package com.beamUp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeamUrlNotFoundException extends RuntimeException {
    public BeamUrlNotFoundException(String message){
        super(message);


    }
}
