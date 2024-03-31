
package basicLogic;

import animals.*;
import exceptions.writeException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static basicLogic.addAnimals0.AddAnimals00;
import static basicLogic.overwritingCommands.OverwritingCommands;
import static basicLogic.stringConversion.StringConversion;
import static basicLogic.stringConversion.StringConversionCommands;

public class  basicLogic {
    public static ArrayList<pets> InitialFileVerificationPets() throws IOException {
        File file;
        ArrayList<pets> arrayListAnimal = new ArrayList<>();
        file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                "animalsTxt\\pets.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String help;
        while ((help = bufferedReader.readLine()) != null){
            ArrayList<String> arrayList = StringConversion(help);
            String nameAn = arrayList.get(0).toLowerCase();
            String name = arrayList.get(1);
            LocalDate dateOfBirth = LocalDate.parse(arrayList.get(2));
            ArrayList<String> executedCommands = StringConversionCommands(arrayList.get(3));
            String breed = arrayList.get(4);
            String character = arrayList.get(5);
            switch (nameAn) {
                case "собака", "пес":
                    arrayListAnimal.add(new dogs(name, dateOfBirth, executedCommands, breed, character));
                    break;
                case "кот", "кошка":
                    arrayListAnimal.add(new cats(name, dateOfBirth, executedCommands, breed, character));
                    break;
                case "хомяк":
                    arrayListAnimal.add(new hamsres(name, dateOfBirth, executedCommands, breed, character));
                    break;
                default:
                    System.out.println("Найдено неизвестное программе имя!");
                    System.exit(1);
            }
        }
        fileReader.close();
        bufferedReader.close();
        return arrayListAnimal;
    }
    public static ArrayList<packAnimals> InitialFileVerificationPackAnimals() throws IOException {
        File file;
        ArrayList<packAnimals> arrayListAnimal = new ArrayList<>();
        file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                "animalsTxt\\packAnimals.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String help;
        while ((help = bufferedReader.readLine()) != null){
            ArrayList<String> arrayList = StringConversion(help);
            String nameAn = arrayList.get(0).toLowerCase();
            String name = arrayList.get(1);
            LocalDate dateOfBirth = LocalDate.parse(arrayList.get(2));
            ArrayList<String> executedCommands = StringConversionCommands(arrayList.get(3));
            String breed = arrayList.get(4);
            String character = arrayList.get(5);
            switch (nameAn) {
                case "лошадь", "конь" ->
                        arrayListAnimal.add(new horses(name, dateOfBirth, executedCommands, breed, character));
                case "ослиха", "осел" ->
                        arrayListAnimal.add(new donkeys(name, dateOfBirth, executedCommands, breed, character));
                case "верблюд" ->
                        arrayListAnimal.add(new camels(name, dateOfBirth, executedCommands, breed, character));
                default -> {
                    System.out.println("Найдено неизвестное программе имя!");
                    System.exit(1);
                }
            }
        }
        fileReader.close();
        bufferedReader.close();
        return arrayListAnimal;
    }
    public static ArrayList<String> GetCommandsPets(ArrayList<pets> animal, int i){
        animal animal1 = animal.get(i);
        if (animal1 instanceof dogs){
            dogs animal00 = (dogs) animal1;
            return animal00.getExecutedCommands();
        } else if (animal1 instanceof cats) {
            cats animal00 = (cats) animal1;
            return animal00.getExecutedCommands();
        } else {
            hamsres animal00 = (hamsres) animal1;
            return animal00.getExecutedCommands();
        }
    }
    public static ArrayList<String> GetCommandsPackAnimals(ArrayList<packAnimals> animal, int i){
        animal animal1 = animal.get(i);
        if (animal1 instanceof camels){
            camels animal00 = (camels) animal1;
            return animal00.getExecutedCommands();
        } else if (animal1 instanceof horses) {
            horses animal00 = (horses) animal1;
            return animal00.getExecutedCommands();
        } else {
            donkeys animal00 = (donkeys) animal1;
            return animal00.getExecutedCommands();
        }
    }
    public static void AddPets(ArrayList<pets> animal) throws writeException {
        animal animal1 = AddAnimals00();
        animal.add((pets) animal1);
    }
    public static void AddPackAnimals(ArrayList<packAnimals> animal) throws writeException {
        animal animal1 = AddAnimals00();
        animal.add((packAnimals) animal1);
    }
    public static void OverWritingComm(int i, int j, animal animal) throws IOException {
        OverwritingCommands(i, j, animal);
    }
    public static void GetAnimalForDate(ArrayList<pets> arrayListPets,
                                        ArrayList<packAnimals> arrayListPackAnimals){
        ArrayList<animal> allAnimal = new ArrayList<>();
        allAnimal.addAll(arrayListPets);
        allAnimal.addAll(arrayListPackAnimals);
        for (int i = 0; i < allAnimal.size(); i++) {
            for (int j = 0; j < allAnimal.size() - i - 1; j++) {
                if(allAnimal.get(j).getDateOfBirth().isAfter(allAnimal.get(j + 1).getDateOfBirth())){
                    animal help = allAnimal.get(j);
                    allAnimal.set(j, allAnimal.get(j + 1));
                    allAnimal.set(j + 1, help);
                }
            }
        }
        for (animals.animal animal : allAnimal) {
            System.out.println(animal.toString());
        }
    }
    public static void GetCount(ArrayList<pets> arrayListPets,
                                ArrayList<packAnimals> arrayListPackAnimals){
        ArrayList<animal> allAnimal = new ArrayList<>();
        allAnimal.addAll(arrayListPets);
        allAnimal.addAll(arrayListPackAnimals);
        System.out.println(allAnimal.size());
    }
}

