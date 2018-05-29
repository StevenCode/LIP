package com.steven.walking.visitor;


public class VarNode extends ExprNode {
    public VarNode(Token token) {
        super(token);
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }
}
