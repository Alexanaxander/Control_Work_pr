package animals;

import java.util.ArrayList;
import java.util.Calendar;

public class donkeys extends packAnimals{
    private String name;
    private Calendar dateOfBirth;
    private ArrayList<String> executedCommands;
    private String breed;
    private String character;

    public donkeys(String name, Calendar dateOfBirth, ArrayList<String> executedCommands,
                String breed, String character) {
        super("donkeys");
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.executedCommands = executedCommands;
        this.breed = breed;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ArrayList<String> getExecutedCommands() {
        return executedCommands;
    }

    public void setExecutedCommands(ArrayList<String> executedCommands) {
        this.executedCommands = executedCommands;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
