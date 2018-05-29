package com.steven.walking.embedded;


public abstract class VecMathNode extends HeteroAST {
    public VecMathNode() {

    }

    public VecMathNode(Token token) {
        super(token);
    }

    public void print(){
        System.out.println(token != null ? token.toString() : "<null>");
    }
}
