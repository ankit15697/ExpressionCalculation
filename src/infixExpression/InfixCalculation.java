package infixExpression;
import java.util.*;
import calculationController.*;
// This is main class which will be responsible for handling the input expression and will give control to the controller class
public class InfixCalculation {

    // Main function begins from here
    public  static void main (String args[]){
        // input will be taken from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input Expression !!!");
        String expression = sc.nextLine();
        ExpressionCalculation exp = new ExpressionCalculation(expression);

    }
}