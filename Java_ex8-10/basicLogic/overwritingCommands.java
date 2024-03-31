package basicLogic;

import animals.*;

import java.io.*;

import static basicLogic.deleteAnimal.DeleteAnimals;

public class overwritingCommands {
    public static void OverwritingCommands(int i, int j, animal animal) throws IOException {
        StringBuilder animalTxt = new StringBuilder();
        if (i == 0){
            if (animal instanceof dogs){
                dogs animal00 = (dogs) animal;
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter()).append("\n");
            } else if (animal instanceof cats) {
                cats animal00 = (cats) animal;
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter()).append("\n");
            } else {
                hamsres animal00 = (hamsres) animal;
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter()).append("\n");
            }
        } else {
            if (animal instanceof camels) {
                camels animal00 = (camels) animal;
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter()).append("\n");
            } else if (animal instanceof horses) {
                horses animal00 = (horses) animal;
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter()).append("\n");
            } else {
                donkeys animal00 = (donkeys) animal;
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter()).append("\n");
            }
        }
//        Изменить команды.
        DeleteAnimals(i, j);
        File file;
        if (i == 0){
            file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                    "animalsTxt\\pets.txt");
        } else {
            file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                    "animalsTxt\\packAnimals.txt");
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String help;
        int k = 0;
        while ((help = bufferedReader.readLine()) != null){
            if (k == j){
                stringBuilder.append(animalTxt).append("\n");
                stringBuilder.append(help).append("\n");
                k++;
            }else{
                stringBuilder.append(help).append("\n");
            }
        }
        fileReader.close();
        bufferedReader.close();
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }
}
