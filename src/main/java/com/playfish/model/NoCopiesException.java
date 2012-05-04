package com.playfish.model;

public class NoCopiesException extends RuntimeException{
    public NoCopiesException(String s) {
        super(s);
    }
}
