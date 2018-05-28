package com.steven.Normalized;

import com.steven.Homo.Token;

import java.util.List;

public class VectorNode extends ExprNode{
    public VectorNode(Token payload, List<ExprNode> elements) {
        super(payload);
        evalType = tVECTOR;
        for (ExprNode element : elements) {
            addChild(element);
        }
    }
}
