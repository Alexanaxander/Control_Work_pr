package basicLogic;

import animals.animal;
import animals.pets;

import java.io.*;
import java.util.ArrayList;

public class deleteAnimal {
    public static void DeleteAnimals(int i, int j) throws FileNotFoundException, IOException {
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
            if (k != j){
                stringBuilder.append(help).append("\n");
            }
            k++;
        }
        fileReader.close();
        bufferedReader.close();
        FileWriter fileWriter = new FileWriter(file, false);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();

    }
}
