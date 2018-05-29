package com.steven.walking.visitor;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static IntNode I(int i) {
        return new IntNode(new Token(Token.INT, String.valueOf(i)));
    }

    public static void main(String[] args) {
        // x = 3+4
       List<StatNode> stats = new ArrayList<StatNode>();
        AddNode a = new AddNode(I(3), new Token(Token.PLUS), I(4));
        VarNode x = new VarNode(new Token(Token.ID, "x"));
        AssignNode assignNode = new AssignNode(x, new Token(Token.ASSIGN, ""), a);
        stats.add(assignNode);

        //print x*[2,3,4]
        Token mult = new Token(Token.MULT, "");
        List<ExprNode> elements = new ArrayList<>();
        elements.add(I(2));
        elements.add(I(3));
        elements.add(I(4));
        VectorNode v = new VectorNode(new Token(Token.VEC), elements);
        VarNode xref = new VarNode(new Token(Token.ID, "x"));
        MultNode pv = new MultNode(xref, mult, v);
        PrintNode p = new PrintNode(new Token(Token.PRINT, "print"), pv);
        stats.add(p);
        StatListNode statlist = new StatListNode(stats);

        // Create visitor and then call visit on root node (statlist)
        PrintVisitor visitor = new PrintVisitor();
        statlist.visit(visitor); // tell root node to visit with this visitor

        // Create visitor and then visit root node (statlist)
        IndependentPrintVisitor indepVisitor = new IndependentPrintVisitor();
        indepVisitor.print(statlist); // tell visitor to print from root
    }
}
