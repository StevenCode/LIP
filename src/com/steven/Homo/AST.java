package com.steven.Homo;

import java.util.ArrayList;
import java.util.List;

public class AST {
    public Token token;
    public List<AST> children;

    public AST() {

    }

    public AST(Token token) {
        this.token = token;
    }

    public AST(int tokenType) {
        this.token = new Token(tokenType);
    }

    public void addChild(AST t) {
        if (children == null) {
            children = new ArrayList<AST>();
        }
        children.add(t);
    }

    public boolean isNill() {
        return token == null;
    }

    public String toString() {
        return token != null ? token.toString() : "nill";
    }

    public String toStringTree() {
        if (children == null || children.size() == 0) {
            return this.toString();
        }
        StringBuilder buf = new StringBuilder();
        if (!isNill()) {
            buf.append("(");
            buf.append(this.toString());
            buf.append(" ");
        }
        for (int i = 0; i < children.size(); i++) {
            AST t = (AST) children.get(i);
            if (i > 0) {
                buf.append(' ');
            }
            buf.append(t.toStringTree());
        }
        if (!isNill()) {
            buf.append(")");
        }
        return buf.toString();
    }
}
