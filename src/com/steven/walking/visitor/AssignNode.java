package com.steven.walking.visitor;


public class AssignNode extends StatNode {
    VarNode id;
    ExprNode value;

    public AssignNode(VarNode id, Token token, ExprNode value) {
        super(token);
        this.id = id;
        this.token = token;
        this.value = value;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }


}
