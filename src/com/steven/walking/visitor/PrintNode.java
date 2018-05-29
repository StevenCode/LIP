package com.steven.walking.visitor;

public class PrintNode extends StatNode {
    ExprNode value;

    public PrintNode(Token token, ExprNode value) {
        super(token);
        this.value = value;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }

}
