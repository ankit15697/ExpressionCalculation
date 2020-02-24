// This class will be responsible for storing the data of expression parts;
package com.expression.part;
public class ExpressionPart {
    private String expressionPart;
    public ExpressionPart(String expressionPart) {
        this.expressionPart = expressionPart;
    }

    // this method will get the expression part
    public String getExpressionPart() {
        return expressionPart;
    }
    // This method will set the  expression Part
    public void setExpressionPart(String expressionPart) {
        this.expressionPart = expressionPart;
    }
}