package exceptions;

import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import static basicLogic.app.App;

public class appException {
    public static void AppException(){
        try {
            HelpException();
        } catch (FileException |  InputMismathExcep | DateTimeParseException e) {
            e.getMessage();
            AppException();
        }
    }
    public static void HelpException() throws FileException, InputMismathExcep, DateTimeParseException{
        try {
            try {
                try {
                    App();
                }catch (IOException e){
                    throw new FileException();
                }
            } catch (DateTimeParseException e){
                System.out.println("Произошла ошибка при форматировании даты, скорей всего " +
                        "вы неправильно ее ввели");
                AppException();
            }
        }catch (InputMismatchException e){
            throw new InputMismathExcep();
        }
    }
}
