package com.steven.walking.visitor;

public class MultNode extends ExprNode {
    ExprNode left, right;

    public MultNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }


}
