package com.steven.lexer;

public class ListLexer extends Lexer {
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;

    public static String[] tokenNames =
            {"n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK"};

    @Override
    public Token nextToken() {
        while (current != EOF) {
            switch (current) {
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    WS();
                    continue;
                case ',':
                    consume();
                    return new Token(COMMA, ",");
                case '[':
                    consume();
                    return new Token(LBRACK, "[");
                case ']':
                    consume();
                    return new Token(RBRACK, "]");
                default:
                    if (isLETTER()) return NAME();
                    throw new Error("invalid character: " + current);
            }

        }
        return new Token(EOF_TYPE, "<EOF>");
    }

    Token NAME() {
        StringBuilder buf = new StringBuilder();
        do {
            buf.append(current);
            consume();
        } while (isLETTER());

        return new Token(NAME, buf.toString());
    }

    private void WS() {
        consume();
    }

    public ListLexer(String input) {
        super(input);
    }

    boolean isLETTER() {
        return current >= 'a' && current <= 'z' || current >= 'A' && current <= 'Z';
    }

    @Override
    public String getTokenName(int tokenType) {
        return tokenNames[tokenType];
    }
}
