package basicLogic;

import animals.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static basicLogic.deleteAnimal.DeleteAnimals;

public class overwritingCommands {
    public static void OverwritingCommands(int i, int j, animal animal) throws IOException {
        StringBuilder animalTxt = new StringBuilder();
        if (i == 0){
            if (animal instanceof dogs){
                dogs animal00 = (dogs) animal;
                ((dogs) animal).setExecutedCommands(SetComm());
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter());
            } else if (animal instanceof cats) {
                cats animal00 = (cats) animal;
                ((cats) animal).setExecutedCommands(SetComm());
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter());
            } else {
                hamsres animal00 = (hamsres) animal;
                ((hamsres) animal).setExecutedCommands(SetComm());
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter());
            }
        } else {
            if (animal instanceof camels) {
                camels animal00 = (camels) animal;
                ((camels) animal).setExecutedCommands(SetComm());
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter());
            } else if (animal instanceof horses) {
                horses animal00 = (horses) animal;
                ((horses) animal).setExecutedCommands(SetComm());
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter());
            } else {
                donkeys animal00 = (donkeys) animal;
                ((donkeys) animal).setExecutedCommands(SetComm());
                animalTxt.append(animal00.getNameAnimal()).append(" ").append(animal00.getName()).append(" ")
                        .append(animal00.getDateOfBirth()).append(" ")
                        .append(String.join(",", animal00.getExecutedCommands()))
                        .append(" ")
                        .append(animal00.getBreed()).append(" ").append(animal00.getCharacter());
            }
        }

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
        int l = 0;
        int k = 0;
        while ((help = bufferedReader.readLine()) != null){
            if (k == j){
                stringBuilder.append(animalTxt).append("\n");
                stringBuilder.append(help).append("\n");
                l++;
            }else{
                stringBuilder.append(help).append("\n");
            }
            k++;
        }
        if (l == 0){
            stringBuilder.append(animalTxt).append("\n");
        }
        fileReader.close();
        bufferedReader.close();
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();
    }

    public static ArrayList<String> SetComm(){
        ArrayList<String> result = new ArrayList<>();
        String s;
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Введите новую команду, и нажмите enter, чтобы продолжить и написать еще одну" +
                    "команду, а если хотите закончить ввод, то введите s, но не в коем случае " +
                    "не ставить пробел!");
            s = in.nextLine();
            if (s.equals("s")){
                break;
            }
            result.add(s);
        }
        return result;
    }
}
