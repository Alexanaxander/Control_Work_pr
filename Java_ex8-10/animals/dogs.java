package animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class dogs extends pets{
    public dogs(String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                String breed, String character) {
        super("pets", name, dateOfBirth, executedCommands, breed, character,
                "собака");
    }
}
