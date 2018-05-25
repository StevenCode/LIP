package com.steven.recursivedescent;

import com.steven.lexer.Lexer;
import com.steven.lexer.Token;

public abstract class Parser {
    Lexer input;
    Token lookahead;

    public Parser(Lexer input) {
        this.input = input;
        consume();
    }

    public void match(int x) {
        if (lookahead.type == x) {
            consume();
        } else
            throw new Error("expectiing " + input.getTokenName(x) + "; found " + lookahead);
    }

    public void consume() {
        lookahead = input.nextToken();
    }
}
