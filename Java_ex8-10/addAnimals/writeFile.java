package addAnimals;

import exceptions.writeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    public static void writeToFile(String string, int i) throws writeException {
        if (i == 0){
            File file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                    "animalsTxt\\pets.txt");
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(string);
                fileWriter.close();
            } catch (IOException e) {
                throw new writeException();
            }
        }
        else {
                File file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                        "animalsTxt\\packAnimals.txt");
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file, true);
                fileWriter.write(string);
                fileWriter.close();
            } catch (IOException e) {
                throw new writeException();
            }
        }
    }
}
