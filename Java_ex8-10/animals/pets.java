package animals;


import java.time.LocalDate;
import java.util.ArrayList;

public abstract class pets extends animal {

    public pets(String nameType, String nameAnimal, String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                String breed, String character) {
        super(nameType,nameAnimal, name, dateOfBirth, executedCommands, breed, character);
    }
}
