package com.steven.walking.embedded;


public abstract class HeteroAST {   // Heterogeneous AST node type
    Token token;                    // Node created from which token?
    public HeteroAST()              { ; }
    public HeteroAST(Token t)       { token = t; }
    /** Create node from token type; used mainly for imaginary tokens */
    public HeteroAST(int tokenType) { this.token = new Token(tokenType); }

    /** Compute string for single node */
    public String toString() { return token.toString(); }
    /** Compute string for a whole tree not just node; default: print token */
    public String toStringTree()    { return toString(); }
}
