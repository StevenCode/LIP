package com.steven.recursivedescent;

import com.steven.lexer.Lexer;

import static com.steven.lexer.ListLexer.*;

public class ListParser extends Parser{
    public ListParser(Lexer input) {
        super(input);
    }

    public void list() {
        match(LBRACK);
        elements();
        match(RBRACK);

    }

    void elements() {
        element();
        while (lookahead.type == COMMA){
            match(COMMA);
            element();
        }

    }

    void element() {
        if (lookahead.type ==NAME) {
            match(NAME);
        }else if ( lookahead.type==LBRACK ){
            list();
        }
        else throw new Error("expecting name or list; found "+lookahead);
    }
}
