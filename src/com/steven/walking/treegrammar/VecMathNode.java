package com.steven.walking.treegrammar;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

public abstract class VecMathNode extends CommonTree {
    public VecMathNode() {

    }

    public VecMathNode(Token token) {
        super(token);
    }

}
