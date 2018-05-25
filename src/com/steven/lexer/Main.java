package com.steven.lexer;



public class Main {

    public static void main(String[] args) {
        String a = "a,b[haha]";

        ListLexer lexer = new ListLexer(a);
        Token t = lexer.nextToken();
        while (t.type != Lexer.EOF_TYPE) {
            System.out.println(t);
            t = lexer.nextToken();
        }

        System.out.println(t);
    }
}
