package animals;

import animals.animal;

public abstract class pets extends animal {

    private String nameAnimal;

    public pets(String nameAnimal) {
        super("animals.pets");
        this.nameAnimal = nameAnimal;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }
}
