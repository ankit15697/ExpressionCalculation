//This class will be for divide by zero
package customExceptions;
public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException(String msg) {
        super(msg);
    }
}