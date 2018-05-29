package com.steven.walking.visitor;

import java.util.ArrayList;
import java.util.List;

public class VectorNode extends ExprNode {
    List<ExprNode> elements = new ArrayList<ExprNode>();

    public VectorNode(Token token, List<ExprNode> elements) {
        super(token);
        this.elements = elements;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }

}
