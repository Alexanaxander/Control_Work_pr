package exceptions;

import java.io.IOException;

public class FileException extends IOException {
    public FileException(){
        super("Произошла ошибка в работой с файлом. Если вы это увидели, значит я чего-то не заметил в программе");
    }
}
