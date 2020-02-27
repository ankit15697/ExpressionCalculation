package com.expression.validation;

import com.expression.exceptions.InValidCharacterException;
import com.expression.model.ExpressionData;
import com.expression.part.ExpressionPart;

import java.util.LinkedList;

public class OperatorValidation implements TokenValidation{
    public boolean performValidation(LinkedList<ExpressionPart> currentExp, int currentIndex) {
        String currentExpression = currentExp.get(currentIndex).getExpressionPart();
        boolean result = true;
        if(currentIndex == currentExp.size()-1 && ExpressionData.isOperator(currentExpression)) {
            result = false;
            throw new InValidCharacterException("!!! Operand is found at the end of expression" +currentExpression);
        }
        if(ExpressionData.isOperator(currentExpression) && (ExpressionData.isOperator(currentExp.get(currentIndex+1).getExpressionPart()) && currentExp.get(currentIndex+1).getExpressionPart().equals(currentExpression))){
            result = false;
            throw new InValidCharacterException("!!! More than two operators found at" +currentExpression + currentExp.get(currentIndex+1).getExpressionPart());
        }
        return result;
    }
}
