import animals.animal;
import animals.dogs;
import exceptions.writeException;

import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static addAnimals.writeFile.writeToFile;
import static basicLogic.addAnimals0.AddAnimals00;
import static basicLogic.stringConversion.StringConversion;

public class main {
    public static void main(String[] args) throws IOException {
        /*
        File file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                "animalsTxt\\pets.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String help;
        while ((help = bufferedReader.readLine()) != null){
            System.out.println(help);
        }
        bufferedReader.close();
        */
        try {
            animal animal = AddAnimals00();
            System.out.println(animal.toString());
        }catch (DateTimeParseException e){
            System.out.println("упс");
        }

    }
}
