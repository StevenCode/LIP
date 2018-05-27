package com.steven.backtrack;

public class NoViableAltException extends RecognitionException{
    public NoViableAltException(String msg) {
        super(msg);
    }
}
