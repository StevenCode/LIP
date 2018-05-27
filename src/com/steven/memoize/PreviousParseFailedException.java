package com.steven.memoize;

import com.steven.backtrack.RecognitionException;

public class PreviousParseFailedException extends RecognitionException{
    public PreviousParseFailedException() {
        super(null);
    }
}
