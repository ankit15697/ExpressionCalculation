// This class will be responsible for validating the expression If error comes then it will throw error
package com.expression.validation;
import com.expression.exceptions.*;
import com.expression.part.*;
import java.util.*;
import com.expression.model.*;
public class ExpressionValidation {

    public ExpressionValidation(){
    }

    // This method will perform validation
    public static boolean isValid(LinkedList<ExpressionPart> expressionParts) {
        // Run loop till end of expressionParts
        boolean result = true;
        result = isparenthesisValid(expressionParts);
        if(!result) {
            return false;
        }
        for(int i = 0; i < expressionParts.size(); i++) {
            String current = expressionParts.get(i).getExpressionPart();
            TokenValidation tokenValidation = TokenValidationGenerator.getCurrentTokenValidation(current);
            result = tokenValidation.performValidation(expressionParts,i);
            if(!result) {
                return false;
            }
        }
        return result;
    }
    private static boolean isparenthesisValid(LinkedList<ExpressionPart> expressionParts) {
        boolean result = true;
        Stack<String> parenthesis = new Stack<String>();
        for (int i =0;i<expressionParts.size(); i++) {
            String currentExpression = expressionParts.get(i).getExpressionPart();
            //Left Parenthesis
            if (currentExpression == "(") {
                parenthesis.push("(");
            }
            //Right Parenthesis
            else if (currentExpression == ")") {
                if (!parenthesis.empty()) {
                    parenthesis.pop();
                } else {
                    result = false;
                    throw new InValidCharacterException("!!! OOPs!! There are invalid bracket combinations");
                }
            }
        }
        // parenthesis check
        if(!parenthesis.empty()) {
            result = false;
            throw new InValidCharacterException("!!! OOPs!! There are invalid bracket combinations");
        }
        return result;
    }
}