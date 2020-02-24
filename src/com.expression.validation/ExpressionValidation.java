// This class will be responsible for validating the expression If error comes then it will throw error
package com.expression.validation;
import com.expression.exceptions.*;
import com.expression.part.*;
import java.util.*;
import com.expression.model.*;
public class ExpressionValidation {
    private ExpressionData expressionData;
    private Stack<String> parenthesis;
    public ExpressionValidation(){
        expressionData = new ExpressionData();
        parenthesis = new Stack<String>();
    }
    public void isValid(LinkedList<ExpressionPart> expressionParts) {
        // Run loop till end of expressionParts
        for(int i = 0; i < expressionParts.size(); i++) {
            String currentExpression = expressionParts.get(i).getExpressionPart();

            //Check that there are valid integer
            int countDecimal = 0;
            boolean flag = false;
            if(currentExpression == "(") {
                parenthesis.push("(");
            }
            else if(currentExpression == ")") {
                if(!parenthesis.empty()) {
                    parenthesis.pop();
                }
                else {
                    throw new InValidCharacterException("!!! OOPs!! There are invalid bracket combinations");
                }
            }
            for(int j = 0; j < currentExpression.length(); j++) {
                if(currentExpression.charAt(j) == '.') {
                    countDecimal++;
                    flag = true;
                }
                else {
                    flag = false;
                }
            }
            if(flag) {
                throw new InValidCharacterException("!!! OOPs!! There is nothing after decimal point " +currentExpression);
            }
            if(countDecimal == 2) {
                throw new InValidCharacterException("!!! OOPs!! There are more than one decimal point in singel number " +currentExpression);
            }
            if(i == expressionParts.size()-1 && expressionData.isOperator(currentExpression)) {
                throw new InValidCharacterException("!!! Operand is found at the end of expression" +currentExpression);
            }
            if(expressionData.isOperator(currentExpression) && (expressionData.isOperator(expressionParts.get(i+1).getExpressionPart()) && expressionParts.get(i+1).getExpressionPart().equals(currentExpression))){
                throw new InValidCharacterException("!!! More than two operators found at" +currentExpression + expressionParts.get(i+1).getExpressionPart());
            }
        }
        if(!parenthesis.empty()) {
            throw new InValidCharacterException("!!! OOPs!! There are invalid bracket combinations");
        }
    }
}