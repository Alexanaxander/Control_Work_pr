package animals;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class animal {
    private String nameType;
    private String nameAnimal;
    private String name;
    private LocalDate dateOfBirth;
    private ArrayList<String> executedCommands;
    private String breed;
    private String character;

    public animal(String nameType,String nameAnimal, String name, LocalDate dateOfBirth, ArrayList<String> executedCommands,
                  String breed, String character) {
        this.nameType = nameType;
        this.nameAnimal = nameAnimal;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.executedCommands = executedCommands;
        this.breed = breed;
        this.character = character;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
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
        this.executedCommands.addAll(executedCommands);
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

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    @Override
    public String toString() {
        return "animal{" +
                "nameType='" + nameType + '\'' +
                ", nameAnimal='" + nameAnimal + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", executedCommands=" + executedCommands +
                ", breed='" + breed + '\'' +
                ", character='" + character + '\'' +
                '}';
    }
}
