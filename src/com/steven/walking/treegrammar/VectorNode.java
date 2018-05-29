package com.steven.walking.treegrammar;


import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
public class VectorNode extends ExprNode {
    public VectorNode(int ttype) { super(new CommonToken(ttype)); }
    public VectorNode(Token t) { super(t); }
}
