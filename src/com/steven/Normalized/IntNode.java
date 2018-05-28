package com.steven.Normalized;

import com.steven.Homo.Token;

public class IntNode extends ExprNode{
    public IntNode(Token payload) {
        super(payload);
        evalType = tINTEGER;
    }
}
