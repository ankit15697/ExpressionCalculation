import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.expression.controller.*;

// This is main class which will be responsible for handling the input expression and will give control to the controller class
public class InfixCalculation  {

    // Main function begins from here
    public  static void main (String args[])  {
        int numberOfexpressions;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of expressions want to evaluate : ");
        numberOfexpressions = sc.nextInt();
        while(numberOfexpressions--!= 0) {
            // input will be taken from the user
            String expression="";
            System.out.println("Enter Expression ");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                expression = reader.readLine();
            }
            catch (IOException e){
                e.getMessage();
            }

            // Controller object is being created here
            ExpressionCalculation exp = new ExpressionCalculation(expression);
            exp.performCalculation();
        }
    }
}