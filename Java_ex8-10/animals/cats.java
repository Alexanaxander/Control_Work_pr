package animals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class cats extends pets{

    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<String> executedCommands;
    private String breed;
    private String character;

    public cats(String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                String breed, String character) {
        super("cats");
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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
