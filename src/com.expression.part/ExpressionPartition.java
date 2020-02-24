// This class will be responsilbe for dividing expression into smaller parts
// This class will return the linked list of the expression parts
package com.expression.part;
import java.util.*;

import com.expression.exceptions.*;
import com.expression.model.*;


public  class ExpressionPartition {
    // These linked list will be used to store the objects of expression Parts
    private LinkedList <ExpressionPart> expressionParts;
    private String expression;
    private ExpressionData expressionData;
   // Constructor
    public ExpressionPartition(String expression) {
        this.expression = expression;
        expressionParts = new LinkedList<ExpressionPart> ();
        expressionData = new ExpressionData();
    }
    // This method will convert expression into expression parts
    public void convertIntoExpressionParts() {
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if(currentChar == '(') {
                expressionParts.add(new ExpressionPart("("));
            }
            else if(currentChar == ')') {
                expressionParts.add(new ExpressionPart(")"));
            }
            else if(currentChar == ' ') {
                continue;
            }
            else if(Character.isDigit(currentChar) || currentChar == '.') {
                StringBuffer currentNumber = new StringBuffer();
                while(i<expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) =='.')) {
                    currentNumber.append(expression.charAt(i++));
                }
                if(i<expression.length()) {
                    i--;
                }
                expressionParts.add(new ExpressionPart(currentNumber.toString()));
                continue;
            }
            else if(Character.isAlphabetic(currentChar)) {
                StringBuffer currentOperator = new StringBuffer();
                while (i < expression.length() && (Character.isAlphabetic(expression.charAt(i)))) {
                    currentOperator.append(expression.charAt(i++));
                }
                if(i <  expression.length()) {
                    i--;
                }
                String currentOp = currentOperator.toString();
                if(expressionData.isOperator(currentOp)) {
                    expressionParts.add(new ExpressionPart(currentOp));
                }
                else {
                    throw new InValidCharacterException("!!! Some Invalid Operator has been found!!! "+currentOp);
                }
                continue;
            }
            else {
                String currentOp = Character.toString(currentChar);
                if(expressionData.isOperator(currentOp)) {
                    expressionParts.add(new ExpressionPart(currentOp));
                }
                else {
                    throw new InValidCharacterException("!!! Some Invalid Operator has been found!!! "+currentOp);
                }
            }
        }
    }

    public LinkedList<ExpressionPart> getExpressionParts() {
        return expressionParts;
    }
}