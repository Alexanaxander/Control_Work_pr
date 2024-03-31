package animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class horses extends packAnimals{
    public horses(String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                   String breed, String character) {
        super("packAnimals", name, dateOfBirth, executedCommands, breed, character,
                "лошадь");
    }
}
