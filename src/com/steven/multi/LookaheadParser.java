package com.steven.multi;

import static com.steven.lexer.ListLexer.COMMA;
import static com.steven.lexer.ListLexer.LBRACK;
import static com.steven.lexer.ListLexer.RBRACK;

public class LookaheadParser extends Parser{
    public LookaheadParser(Lexer input, int k) {
        super(input, k);
    }

    public void list() {
        match(LBRACK);
        elements();
        match(RBRACK);

    }

    void elements() {
        element();
        while (LA(1) == COMMA){
            match(COMMA);
            element();
        }

    }

    void element() {
        if ( LA(1)==LookaheadLexer.NAME && LA(2)==LookaheadLexer.EQUALS ) {
            match(LookaheadLexer.NAME);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.NAME);
        }
        else if ( LA(1)==LookaheadLexer.NAME ) match(LookaheadLexer.NAME);
        else if ( LA(1)==LookaheadLexer.LBRACK ) list();
        else throw new Error("expecting name or list; found "+LT(1));
    }
}
