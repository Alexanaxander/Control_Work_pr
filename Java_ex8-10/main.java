import animals.dogs;
import exceptions.writeException;

import java.io.*;
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
        dogs dog = (dogs) AddAnimals00();
        System.out.println(dog.toString());

    }
}
