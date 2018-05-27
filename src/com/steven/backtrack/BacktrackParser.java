package com.steven.backtrack;

import com.steven.multi.Lexer;
import com.steven.multi.LookaheadLexer;

/**
 * Created by steven on 2018/5/27.
 */
public class BacktrackParser extends Parser{
    public BacktrackParser(Lexer input) {
        super(input);
    }

    /** stat: list EOF | assign EOF; **/
    public void stat() throws RecognitionException {
        // attempt alternative 1: list EOF
        if ( speculate_stat_alt1() ) {
            list(); match(Lexer.EOF_TYPE);
        }
        // attempt alternative 2: assign EOF
        else if ( speculate_stat_alt2() ) {
            assign(); match(Lexer.EOF_TYPE);
        }
        // must be an error; neither matched; LT(1) is lookahead token 1
        else throw new NoViableAltException("expecting stat found "+LT(1));
    }

    public boolean speculate_stat_alt1() {
        boolean success = true;
        mark(); // mark this spot in input so we can rewind
        try { list(); match(Lexer.EOF_TYPE); }
        catch (RecognitionException e) { success = false; }
        release(); // either way, rewind to where we were
        return success;
    }

    public boolean speculate_stat_alt2() {
        boolean success = true;
        mark(); // mark this spot in input so we can rewind
        try { assign(); match(Lexer.EOF_TYPE); }
        catch (RecognitionException e) { success = false; }
        release(); // either way, rewind to where we were
        return success;
    }

    /** assign : list '=' list ; // parallel assignment */
    public void assign() throws RecognitionException {
        list(); match(LookaheadLexer.EQUALS); list();
    }

    /** list : '[' elements ']' ; // match bracketed list */
    public void list() throws RecognitionException {
        match(LookaheadLexer.LBRACK); elements(); match(LookaheadLexer.RBRACK);
    }

    /** elements : element (',' element)* ; // match comma-separated list */
    void elements() throws RecognitionException {
        element(); while ( LA(1)== LookaheadLexer.COMMA ) { match(LookaheadLexer.COMMA); element(); }
    }

    /** element : name '=' NAME | NAME | list ; // assignment, name or list */
    void element() throws RecognitionException {
        if ( LA(1)==LookaheadLexer.NAME && LA(2)==LookaheadLexer.EQUALS) {
            match(LookaheadLexer.NAME);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.NAME);
        }
        else if ( LA(1)==LookaheadLexer.NAME ) match(LookaheadLexer.NAME);
        else if ( LA(1)==LookaheadLexer.LBRACK ) list();
        else throw new NoViableAltException("expecting element found "+LT(1));
    }
}
