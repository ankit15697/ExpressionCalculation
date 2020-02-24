// This class will be responsible for data storation
package com.expression.model;
public class ExpressionData {
    private String unaryOperators[] = {"sin", "cos", "tan"};
    private String binaryOperators[] = {"+", "-", "*", "/"};
    //Constructor
    public ExpressionData() {

    }
    // This function will return true if operator is unary
    public boolean isUnary(String operator) {
        for(int  i = 0; i < unaryOperators.length; i++) {
            if(unaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }
    // This function will return true if Operator is binary
    public boolean isBinary(String operator) {
        for(int i = 0; i < binaryOperators.length; i++) {
            if(binaryOperators[i].equals(operator)) {
                return  true;
            }
        }
        return false;
    }
    public boolean isOperator(String operator) {
        for( int i = 0; i < unaryOperators.length; i++) {
            if(unaryOperators[i].equals(operator)) {
                return true;
            }
        }
        for (int i = 0; i < binaryOperators.length; i++) {
            if(binaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }
}