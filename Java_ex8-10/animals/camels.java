package animals;

import java.time.LocalDate;
import java.util.ArrayList;

public class camels extends packAnimals {

    public camels(String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                  String breed, String character) {
        super("packAnimals", "верблюд", name, dateOfBirth, executedCommands, breed, character);
    }
}
