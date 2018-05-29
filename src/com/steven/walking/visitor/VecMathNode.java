package com.steven.walking.visitor;


public abstract class VecMathNode extends HeteroAST {
    public VecMathNode() {

    }

    public VecMathNode(Token token) {
        super(token);
    }

    public abstract void visit(VecMathVisitor visitor);

}
