package com.steven.walking.visitor;


import java.util.ArrayList;
import java.util.List;

public class StatListNode extends VecMathNode {
    List<StatNode> elements = new ArrayList<StatNode>();

    public StatListNode(List<StatNode> elements) {
        super(new Token(Token.STAT_LIST));
        this.elements = elements;
    }

    public void visit(VecMathVisitor visitor) {
        visitor.visit(this);
    }

}
