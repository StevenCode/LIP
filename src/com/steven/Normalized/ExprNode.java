package com.steven.Normalized;

import com.steven.Homo.AST;
import com.steven.Homo.Token;

public abstract class ExprNode extends AST {
    public static final int tINVALID = 0; // invalid expression type
    public static final int tINTEGER = 1; // integer expression type
    public static final int tVECTOR = 2;  // vector expression type

    int evalType;

    public int getEvalType() {
        return evalType;
    }

    public ExprNode(Token payload) {
        super(payload);
    }
    /** ExprNode's know about the type of an expresson, include that */
    public String toString() {
        if ( evalType != tINVALID ) {
            return super.toString()+"<type="+
                    (evalType == tINTEGER ? "tINTEGER" : "tVECTOR")+">";
        }
        return super.toString();
    }

}
