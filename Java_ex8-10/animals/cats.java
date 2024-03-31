package animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class cats extends pets{
    public cats(String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                  String breed, String character) {
        super("pets","кошка", name, dateOfBirth, executedCommands, breed, character);
    }
}
