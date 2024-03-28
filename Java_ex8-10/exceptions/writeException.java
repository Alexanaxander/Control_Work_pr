package exceptions;

import java.io.IOException;

public class writeException extends IOException {
    public writeException(){
        super("Произошла ошибка при записи данных в файл. Прошу строго не судить, так как если вы " +
                "увидели эту ошибку, значит я ее не заметил, либо забыл обработать. Вот)");
    }
}
