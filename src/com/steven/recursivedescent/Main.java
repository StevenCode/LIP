package com.steven.recursivedescent;

import com.steven.lexer.ListLexer;

public class Main {

    public static void main(String[] args) {
        String s = "[ab,b,c,d]";

        ListParser parser = new ListParser(new ListLexer(s));
        parser.list();
    }

}
