package com.steven.walking.visitor;


public class AddNode extends ExprNode {
    ExprNode left, right; // named, node-specific, irregular children
    public AddNode(ExprNode left, Token addToken, ExprNode right) {
        super(addToken);
        this.left = left;
        this.right = right;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }

}
