package com.steven.walking.embedded;

public class MultNode extends ExprNode {
    ExprNode left, right;

    public MultNode(ExprNode left, Token t, ExprNode right) {
        super(t);
        this.left = left;
        this.right = right;
    }

    public void print() {
        left.print();
        System.out.println("*");
        right.print();
    }
}
