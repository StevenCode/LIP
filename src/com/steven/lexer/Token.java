package com.steven.lexer;

public class Token {
    public int type;
    public String text;

    public Token(int type, String text) {
        this.text = text;
        this.type = type;
    }

    public String toString() {
        String tname = ListLexer.tokenNames[type];
        return "<'"+text+"',"+tname+">";
    }
}
