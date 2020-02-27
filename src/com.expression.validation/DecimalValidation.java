package com.expression.validation;

import com.expression.exceptions.InValidCharacterException;
import com.expression.part.ExpressionPart;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class DecimalValidation implements TokenValidation{
    @Override
    public boolean performValidation(@NotNull LinkedList<ExpressionPart> currentExp, int currentIndex) {
        boolean result = true;
        String currentExpression = currentExp.get(currentIndex).getExpressionPart();
        int countDecimal = 0;
        boolean flag = false;
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
            result = false;
            throw new InValidCharacterException("!!! OOPs!! There is nothing after decimal point " +currentExpression);
        }
        if(countDecimal == 2) {
            result = false;
            throw new InValidCharacterException("!!! OOPs!! There are more than one decimal point in singel number " +currentExpression);
        }
        return result;
    }
}
