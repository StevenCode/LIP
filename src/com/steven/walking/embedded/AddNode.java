package com.steven.walking.embedded;


public class AddNode extends ExprNode {
    ExprNode left, right; // named, node-specific, irregular children
    public AddNode(ExprNode left, Token addToken, ExprNode right) {
        super(addToken);
        this.left = left;
        this.right = right;
    }

    public void print() {
        left.print();
        System.out.println("+");
        right.print();
    }
}
