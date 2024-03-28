package addAnimals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    public static void writeToFile(String string, int i) throws IOException {
        if (i == 0){
            File file = new File("E:\\MyPrograms\\control_work_prog\\Java_ex8-10\\" +
                    "animalsTxt\\pets.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(string);
            fileWriter.close();
        }
    }
}
