package com.steven.memoize;

import com.steven.backtrack.NoViableAltException;
import com.steven.backtrack.RecognitionException;
import com.steven.multi.Lexer;
import com.steven.multi.LookaheadLexer;

import java.util.HashMap;
import java.util.Map;

public class BacktrackParser extends Parser{

    public BacktrackParser(Lexer input) { super(input); }

    /** clear all data out of memoization dictionaries */
    public void clearMemo() {
        list_memo.clear();
    }

    /** stat : list EOF | assign EOF ; */
    public void stat() throws RecognitionException {
        // attempt alternative 1: list EOF
        if ( speculate_stat_alt1() ) {
            list(); match(Lexer.EOF_TYPE);
        }
        // attempt alternative 2: assign EOF
        else if ( speculate_stat_alt2() ) {
            System.out.println("predict alternative 2");
            assign(); match(Lexer.EOF_TYPE);
        }
        // must be an error; neither matched
        else throw new NoViableAltException("expecting stat found "+LT(1));
    }

    public boolean speculate_stat_alt1() {
        System.out.println("attempt alternative 1");
        boolean success = true;
        mark(); // mark this spot in input so we can rewind
        try { list(); match(Lexer.EOF_TYPE); }
        catch (RecognitionException e) { success = false; }
        release(); // either way, rewind to where we were
        return success;
    }

    public boolean speculate_stat_alt2() {
        System.out.println("attempt alternative 2");
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

    // match '[' elements ']'
    public void _list() throws RecognitionException {
        System.out.println("parse list rule at token index: "+index());
        match(LookaheadLexer.LBRACK);
        elements();
        match(LookaheadLexer.RBRACK);
    }

    /** Map input position to FAILED or previous stop token index.
     *  null implies we've not parsed this rule at that index.
     */
    Map<Integer, Integer> list_memo = new HashMap<Integer, Integer>();

    /** list : '[' elements ']' ; // match bracketed list */
    public void list() throws RecognitionException {
        boolean failed = false;
        int startTokenIndex = index(); // get current token position
        if ( isSpeculating() && alreadyParsedRule(list_memo) ) return;
        // must not have previously parsed list at tokenIndex; parse it
        try { _list(); }
        catch (RecognitionException re) { failed = true; throw re; }
        finally {
            //  succeed or fail, must record result if backtracking
            if (isSpeculating()) memoize(list_memo, startTokenIndex, failed);
        }
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
