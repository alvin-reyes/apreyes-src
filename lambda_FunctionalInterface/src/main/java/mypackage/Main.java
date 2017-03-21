package mypackage;

public class Main {
   
    public static void main(String[] args) {

        Calculator multiply = (x, y) -> x * y;
        Calculator divide = (x, y) -> x / y;
        
        // Call methods of lambda expressions
        int product = multiply.calculate(50, 10);
        int quotient = divide.calculate(50, 10);

        System.out.println("product = " + product + " quotient = " + quotient);
       
        sampleMethod (multiply, divide);
        sampleMethod((x, y) -> x * y, (x, y) -> x / y);
       
       
    }
   
    public static void sampleMethod(Calculator m, Calculator d){
        int product = m.calculate(60, 10);
        int quotient = d.calculate(60, 10);
        System.out.println("product = " + product + " quotient = " + quotient);
    }
    
}