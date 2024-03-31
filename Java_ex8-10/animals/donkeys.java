package animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class donkeys extends packAnimals{
    public donkeys(String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                String breed, String character) {
        super("packAnimals", "осел", name, dateOfBirth, executedCommands, breed, character);
    }
}
