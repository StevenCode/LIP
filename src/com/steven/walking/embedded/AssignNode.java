package com.steven.walking.embedded;


public class AssignNode extends StatNode {
    VarNode id;
    ExprNode value;

    public AssignNode(VarNode id, Token token, ExprNode value) {
        super(token);
        this.id = id;
        this.token = token;
        this.value = value;
    }

    public void print() {
        id.print();
        System.out.println("=");
        value.print();
        System.out.println();
    }
}
