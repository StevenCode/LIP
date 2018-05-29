package com.steven.walking.embedded;

public class PrintNode extends StatNode {
    ExprNode value;

    public PrintNode(Token token, ExprNode value) {
        super(token);
        this.value = value;
    }

    public void print() {
        System.out.println("print ");
        value.print();
        System.out.println();
    }
}
