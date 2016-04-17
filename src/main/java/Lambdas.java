/**
 * Created by fcalderon on 4/16/16.
 */
public class Lambdas {
    public static void main(String args[]){
        Lambdas tester = new Lambdas();

       /* Scope
        Using lambda expression, you can refer to final variable or effectively
        final variable (which is assigned only once). Lambda expression throws a compilation error,
        if a variable is assigned a value the second time.*/
        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //without type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        //without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Fernando");
        greetService2.sayMessage("Luis");
    }

    //interface where substraction, multiplication and division overrides operation method
    interface MathOperation {
        int operation(int a, int b);
    }

    //interface where greetservice 1 and 2 overrides saymessage method
    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
