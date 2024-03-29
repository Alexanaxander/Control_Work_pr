package animals;

import animals.animal;

public class packAnimals extends animal {
    private String nameAnimal;

    public packAnimals(String nameAnimal) {
        super("animals.packAnimals");
        this.nameAnimal = nameAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }
}
