package com.steven.walking.treegrammar;

import org.antlr.runtime.Token;
public abstract class StatNode extends VecMathNode {
    public StatNode() {

    }

    public StatNode(Token token) {
        super(token);
    }
}
