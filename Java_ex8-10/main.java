import animals.animal;
import animals.dogs;
import animals.packAnimals;
import animals.pets;
import exceptions.writeException;

import java.io.*;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static addAnimals.writeFile.writeToFile;
import static basicLogic.addAnimals0.AddAnimals00;
import static basicLogic.basicLogic.*;
import static basicLogic.deleteAnimal.DeleteAnimals;
import static basicLogic.overwritingCommands.OverwritingCommands;
import static basicLogic.stringConversion.StringConversion;

public class main {
    public static void main(String[] args) throws IOException {
//        try {
//            animal animal = AddAnimals00();
//        }catch (DateTimeParseException e){
//            System.out.println("упс");
//        }
        ArrayList<pets> arrayListPets = InitialFileVerificationPets();
        ArrayList<packAnimals> arrayListPackAnimals = InitialFileVerificationPackAnimals();
        OverwritingCommands(1, 0, arrayListPackAnimals.get(0));
    }
}

