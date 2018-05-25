package com.steven.lexer;

public abstract class Lexer {
    public static final char EOF = (char) -1;
    public static final int EOF_TYPE = 1;
    String input;
    int position = 0;
    char current;

    public Lexer(String input) {
        this.input = input;
        current = input.charAt(position); //prime lookahead
    }

    public void consume() {
        position++;
        if (position >= input.length()) {
            current = EOF;
        } else current = input.charAt(position);
    }

    public void match(char x) {
        if (current == x) {
            consume();
        } else throw new Error("expecting " + x + ", found " + current);
    }

    public abstract Token nextToken();
    public abstract String getTokenName(int tokenType);
}
