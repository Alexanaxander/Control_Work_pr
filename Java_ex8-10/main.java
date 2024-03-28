import exceptions.writeException;

import java.io.IOException;

import static addAnimals.writeFile.writeToFile;

public class main {
    public static void main(String[] args){
        try {
            writeToFile("Hello, world\n", 1);
        } catch (writeException e) {
            System.out.println(e.getMessage());;
        }
    }
}
