package exceptions;

public class InputMismathExcep extends Throwable {
    public InputMismathExcep(){
        System.out.println("Произонла ошибка при форматировании строки в число, " +
                "возможно вы неправильно ввели число!");
    }
}
