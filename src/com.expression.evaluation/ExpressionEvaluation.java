//This class will be responsible for evaluating the expression
package com.expression.evaluation;
import com.expression.exceptions.*;
import com.expression.operators.*;
import com.expression.model.*;
import com.expression.part.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;
public class ExpressionEvaluation {
    private Stack<Double> values;
    private Stack<String> expressionOperators;
    // Constructor
    public ExpressionEvaluation() {
        values = new Stack<Double>();
        expressionOperators = new Stack<String> ();
    }
    // This method will evalute the expression
    public ExpressionPart evaluate(@NotNull LinkedList<ExpressionPart> expressionParts) {
        // Run a loop till end of the expression size
        for (int i = 0; i < expressionParts.size(); i++) {
            String currentExpression = expressionParts.get(i).getExpressionPart().trim();
            if(currentExpression.equals("(")) {
                expressionOperators.push(currentExpression);
            }
            else if(currentExpression.equals(")")) {
                while(!expressionOperators.peek().equals("(")) {
                  try {
                      performCalculation();
                  }
                  catch (NullOperatorException e) {
                      e.getMessage();
                  }
                }
                expressionOperators.pop();
            }
            //If current is operator
            else if(!ExpressionData.isOperator(currentExpression)) {
                values.push(Double.parseDouble(currentExpression));
            }
            // If negative number occurs here
            else if(currentExpression.equals("-") && (i==0 || (ExpressionData.isOperator(expressionParts.get(i-1).getExpressionPart()) || expressionParts.get(i-1).getExpressionPart() == "("))) {
                    Double negativeValue = Double.parseDouble(expressionParts.get(i+1).getExpressionPart());
                    negativeValue = -negativeValue;
                    values.push(negativeValue);
                    i=i+1;
            }
            else {
                while(!expressionOperators.empty() && precedence(currentExpression, expressionOperators.peek())) {
                    try {
                        performCalculation();
                    }
                    catch (NullOperatorException e) {
                        e.getMessage();
                    }
                }
                expressionOperators.push(currentExpression);
            }
        }
        while(!expressionOperators.empty()) {
            try {
                performCalculation();
            }
            catch (NullOperatorException e) {
                e.getMessage();
            }
        }
        return (new ExpressionPart(String.valueOf(values.pop())));
    }
    // This method will check whether given string is numeric type or not
    private boolean isNumeric(String operand) {
        boolean isNumber = true;
        try {
            Double num = Double.parseDouble(operand);
        }
        catch (NumberFormatException e) {
            isNumber = false;
        }
        return isNumber;
    }
    // This method will give the operator precedence
    private  boolean precedence(String first, String second) {
        if(second.equals("(") || second.equals("(")) {
            return false;
        }
        if((first.equals( "*") || first.equals("/")) && (second.equals("+") || second.equals("-"))) {
            return false;
        }
        if(ExpressionData.isUnary(first)) {
            return false;
        }
        return true;
    }

    // This method will perform calculation
    private void performCalculation() throws NullOperatorException {
        String currentOp = expressionOperators.pop();
        Operator currentOperator = OperatorGeneration.getOperator(currentOp);
        if(currentOperator == null) {
            throw new NullOperatorException("!!!Entered operator has not been found ");
        }
        if (ExpressionData.isUnary(currentOp)) {
            try {
                values.push(currentOperator.doCalculation(values.pop()));
            }
            catch (InValidOperandException e) {
                e.getMessage();
            }
        }
        else if(ExpressionData.isBinary(currentOp)) {
            try {
                values.push(currentOperator.doCalculation(values.pop(), values.pop()));
            }
            catch (InValidOperandException e){
                e.getMessage();
            }
        }
    }
}