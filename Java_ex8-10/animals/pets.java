package animals;

import animals.animal;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class pets extends animal {

    private String nameAnimal;

    public pets(String nameType, String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                String breed, String character, String nameAnimal) {
        super(nameType, name, dateOfBirth, executedCommands, breed, character);
        this.nameAnimal = nameAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }
}
