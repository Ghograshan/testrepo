public class MathOperation {

    interface IMathOperation{
        int operation(int a, int b);
    }

    interface IGreetingService{
        void sayMessage(String message);
    }

    private int operate(int a, int b, IMathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation();

        IMathOperation addition = (int a, int b) -> a + b;
        IMathOperation subtraction = (int a, int b) -> a - b;
        IMathOperation multiplication = (int a, int b) -> a * b;
        IMathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + mathOperation.operate(10, 5, addition));
        System.out.println("10 - 5 = " + mathOperation.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + mathOperation.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + mathOperation.operate(10, 5, division));

        IGreetingService greetServiceForEnglishUser = message -> System.out.println("Hello " + message);
        IGreetingService greetServiceForTurkishUser = message -> System.out.println("Merhaba " + message);

        greetServiceForEnglishUser.sayMessage("John");
        greetServiceForTurkishUser.sayMessage("Arda");
    }
}
