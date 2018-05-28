package com.steven.IR;

import com.steven.lexer.Token;

public class TokenNode extends ParseTree {
    public Token token;

    public TokenNode(Token token) {
        this.token = token;
    }
}
