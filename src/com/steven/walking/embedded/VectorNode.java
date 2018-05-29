package com.steven.walking.embedded;

import java.util.ArrayList;
import java.util.List;

public class VectorNode extends ExprNode {
    List<ExprNode> elements = new ArrayList<ExprNode>();

    public VectorNode(Token token, List<ExprNode> elements) {
        super(token);
        this.elements = elements;
    }

    public void print() {
        System.out.println("[");
        if (elements != null) {
            for (int i = 0; i < elements.size(); i++) {
                ExprNode child = elements.get(i);
                if (i > 0) {
                    System.out.println(" ,");
                }
                child.print();
            }
        }
        System.out.println("]");
    }
}
